package com.ds.servlet;

import com.ds.entity.Package;
import com.ds.entity.builder.PackageBuilder;
import com.ds.html.HtmlPageBuilder;
import com.ds.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.SimpleDateFormat;

public class AdminServlet extends HttpServlet {

    private AdminService adminService;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            URL url = new URL("http://localhost:8079/adminservice?wsdl");

            QName qName = new QName("http://service.ds.com/", "AdminServiceImplService");

            Service service = Service.create(url, qName);

            adminService = service.getPort(AdminService.class);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(!request.getSession().getAttribute("admin").equals(1)){
            response.sendRedirect("/denied");
            return;
        }

        String notification = "";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String action = request.getParameter("action");

        if("Add".equals(action)){
            try{
                Package pack = new PackageBuilder()
                        .setName(request.getParameter("name"))
                        .setDescription(request.getParameter("description"))
                        .setSenderCity(request.getParameter("senderCity"))
                        .setDestCity(request.getParameter("destinationCity"))
                        .build();

                notification = adminService.addPackage(pack,
                        Integer.parseInt(request.getParameter("senderId")),
                        Integer.parseInt(request.getParameter("receiverId")));

            } catch (Exception e){
                notification = "Please enter appropriate data";
            }
        } else if("Delete".equals(action)){
            try{
                notification = adminService.deletePackage(
                        Integer.parseInt(request.getParameter("id"))
                );
            } catch (Exception e){
                notification = "Please enter appropriate data";
            }
        } else if("Register package".equals(action)){
            try{
                notification = adminService.registerPackage(
                        Integer.parseInt(request.getParameter("id"))
                );
            } catch (Exception e){
                notification = "Please enter appropriate data";
            }
        } else if("Update status".equals(action)){
            try {
                String[] time = request.getParameter("time").split("T");

                notification = adminService.updateTracking(
                        Integer.parseInt(request.getParameter("id")),
                        request.getParameter("city"),
                        sdf.parse(time[0] + " " + time[1])
                );
            } catch (Exception e){
                notification = "Please enter appropriate data";
            }
        }

        request.getSession().setAttribute("notification",
                notification);

        response.sendRedirect("/admin");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getSession().getAttribute("admin") != null) {
            if (!request.getSession().getAttribute("admin").equals(1)) {
                response.sendRedirect("/denied");
                return;
            }
        } else {
            response.sendRedirect("/denied");

            return;
        }

        request.getSession().invalidate();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(HtmlPageBuilder.getAdminHtml(request, adminService.getUsers(), adminService.getPackages()));

    }
}

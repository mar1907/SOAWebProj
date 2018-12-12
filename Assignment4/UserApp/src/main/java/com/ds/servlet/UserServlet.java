package com.ds.servlet;

import com.ds.html.HtmlPageBuilder;
import com.ds.generatedservice.ClientService;
import com.ds.generatedservice.ClientServiceSoap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {

    ClientServiceSoap clientService;

    @Override
    public void init() throws ServletException {
        super.init();

        clientService = new ClientService().getClientServiceSoap();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!request.getSession().getAttribute("admin").equals(0)){
            response.sendRedirect("/denied");
            return;
        }

        String action = request.getParameter("action");

        if("Search by name".equals(action)){
            request.getSession().setAttribute("search", request.getParameter("name"));
        } else if("Check status".equals(action)) {
            request.getSession().setAttribute("track", Integer.parseInt(request.getParameter("id")));
        }


        response.sendRedirect("/user");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("admin")!=null) {
            if (!request.getSession().getAttribute("admin").equals(0)) {
                response.sendRedirect("/denied");
                return;
            }
        } else {
            response.sendRedirect("/denied");

            return;
        }

        Integer trackId = (Integer) request.getSession().getAttribute("track");

        String track = "";

        if(trackId != null){
            track = clientService.getTracking(trackId);
        }

        String searchTerm = (String) request.getSession().getAttribute("search");

        if(searchTerm == null){
            searchTerm = "";
        }

        int userId = Integer.parseInt(request.getSession().getAttribute("userid").toString());

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(HtmlPageBuilder.getUserHtml(request, clientService.getPackages(userId),
                clientService.searchPackage(searchTerm), track));

    }
}

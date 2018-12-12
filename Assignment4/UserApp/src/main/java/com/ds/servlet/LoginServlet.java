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

public class LoginServlet extends HttpServlet {

    ClientServiceSoap clientService;

    @Override
    public void init() throws ServletException {
        super.init();

        clientService = new ClientService().getClientServiceSoap();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("username");
        String pass = request.getParameter("password");

        int admin = clientService.logIn(name, pass);

        request.getSession().setAttribute("admin", admin);

        if(admin == 1){
            response.sendRedirect("/admin");
        } else if(admin == 0){
            int userId = clientService.getUserId(name, pass);
            request.getSession().setAttribute("userid", userId);

            System.out.println(userId);

            response.sendRedirect("/user");
        } else {
            response.sendRedirect("/");
            request.getSession().setAttribute("message", "Invalid login.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = (String) request.getSession().getAttribute("message");

        request.getSession().invalidate();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(HtmlPageBuilder.getLoginHtml(message));
    }
}

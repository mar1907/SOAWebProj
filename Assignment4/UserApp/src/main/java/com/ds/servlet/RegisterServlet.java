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

public class RegisterServlet extends HttpServlet {

    ClientServiceSoap clientService;

    @Override
    public void init() throws ServletException {
        super.init();

        clientService = new ClientService().getClientServiceSoap();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Here");

        String name = request.getParameter("username");
        String pass = request.getParameter("password");

        String message = clientService.register(name, pass);

        response.sendRedirect("/");
        request.getSession().setAttribute("message", message);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(HtmlPageBuilder.getRegisterHtml(request));
    }
}

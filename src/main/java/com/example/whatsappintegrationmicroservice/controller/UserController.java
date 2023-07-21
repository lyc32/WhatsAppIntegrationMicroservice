package com.example.whatsappintegrationmicroservice.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "User", value = "/User")
public class UserController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String operation = (String)request.getParameter("operation");
        if(operation.equals("SignIn"))
        {
            response.setContentType("text/html");
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher("/userRegistration.jsp");
            rd.forward(request, response);
        }
        if(operation.equals("HomePage"))
        {
            response.setContentType("text/html");
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }
}

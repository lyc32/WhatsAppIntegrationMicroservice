package com.example.whatsappintegrationmicroservice.controller;

import com.example.whatsappintegrationmicroservice.model.User;
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

        response.setContentType("text/html");
        ServletContext sc = getServletContext();
        request.setAttribute("operation", (String)request.getParameter("operation"));
        User user = (User)request.getSession().getAttribute("User");
        if(user != null)
        {
            request.setAttribute("user", user);
        }
        RequestDispatcher rd = sc.getRequestDispatcher("/userPage.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }
}

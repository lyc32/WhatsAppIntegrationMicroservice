package com.example.whatsappintegrationmicroservice.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "User/SignIn", value = "/User/SignIn")
public class UserSignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println(request.getParameter("userName"));
        System.out.println(request.getParameter("phone"));
        System.out.println(request.getParameter("email"));
        System.out.println(request.getParameter("birthday"));
        System.out.println(request.getParameter("password"));

        boolean signInSuccessful = true;
        if(signInSuccessful)
        {
            response.setContentType("text/html");
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher("/jumpPage.jsp");
            request.setAttribute("returnMessage", "Sign In Successful");
            request.setAttribute("url", "../User?operation=HomePage");
            rd.forward(request, response);
        }
    }
}

package com.example.whatsappintegrationmicroservice.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "User/Logout", value = "/User/Logout")
public class UserLogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession httpSession = request.getSession();
        httpSession.removeAttribute("User");
        response.setContentType("text/html");
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jumpPage.jsp");
        request.setAttribute("returnMessage", "You Have Logged Out");
        request.setAttribute("url", "../User?operation=Login");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }
}

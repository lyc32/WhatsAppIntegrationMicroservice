package com.example.whatsappintegrationmicroservice.servlet;

import com.example.whatsappintegrationmicroservice.model.User;
import com.example.whatsappintegrationmicroservice.severice.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "User/Login", value = "/User/Login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ServletContext servletContext = getServletContext();
        String sqlDriver  = servletContext.getInitParameter("SqlDriver");
        String sqlUrl     = servletContext.getInitParameter("SqlUrl");
        String sqlUserName= servletContext.getInitParameter("SqlUserName");
        String sqlPassword= servletContext.getInitParameter("SqlPassWord");

        UserService userService = new UserService(sqlDriver,sqlUrl,sqlUserName,sqlPassword);

        User user = userService.login((String)request.getParameter("emailOrPhone"), (String)request.getParameter("password"));

        response.setContentType("text/html");
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jumpPage.jsp");
        if(user != null)
        {
            request.setAttribute("returnMessage", "Welcome Back " + user.getUserName());
            request.setAttribute("url", "../User?operation=HomePage");
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("User", user);
        }
        else
        {
            request.setAttribute("returnMessage", "Login Failed :( <br>Your ID and Password Do Not Match<br>Please Try Again");
            request.setAttribute("url", "../User?operation=Login");
        }
        rd.forward(request, response);
    }
}

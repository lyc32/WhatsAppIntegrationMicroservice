package com.example.whatsappintegrationmicroservice.servlet;

import com.example.whatsappintegrationmicroservice.model.User;
import com.example.whatsappintegrationmicroservice.severice.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "User/SignIn", value = "/User/SignIn")
public class UserSignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        User user = new User();
        user.setUserName((String)request.getParameter("userName"));
        user.setPhoneNumber((String)request.getParameter("phone"));
        user.setEmail((String)request.getParameter("email"));
        user.setBirthday((String)request.getParameter("birthday"));
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd");
        user.setJoinDate(sdf.format(new Date()));

        boolean signInSuccessful = userService.signIn(user, (String)request.getParameter("password"));

        response.setContentType("text/html");
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jumpPage.jsp");
        if(signInSuccessful)
        {
            request.setAttribute("returnMessage", "Sign In Successful");
            request.setAttribute("url", "../User?operation=HomePage");
        }
        else
        {
            request.setAttribute("returnMessage", "Sign In Failed");
            request.setAttribute("url", "../User?operation=SignIn");
        }
        rd.forward(request, response);
    }
}

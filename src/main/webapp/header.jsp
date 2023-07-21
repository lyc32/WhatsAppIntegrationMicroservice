<%@ page import="com.example.whatsappintegrationmicroservice.model.User" %>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="User?operation=HomePage">HomePage</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ">
                <li class="nav-item">
                    <a class="nav-link" href="#">Link1</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link2</a>
                </li>
            </ul>
        </div>
        <div class="collapse navbar-collapse justify-content-end">
            <ul class="navbar-nav ">
                <li class="nav-item dropdown text-center" style = "min-width:160px">
                    <a href="#" class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown">
                        <%
                            User user = (User)request.getAttribute("user");
                            String userName = (user == null) ? "Log In": user.getUserName();
                            out.println(userName);
                        %>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end text-center">
                        <%
                            if(userName.equals("Log In"))
                            {
                                out.println("<li><a class=\"dropdown-item \" href=\"User?operation=Login\">Log in</a></li>" +
                                            "<li><a class=\"dropdown-item\" href=\"User?operation=SignIn\">Sign In</a></li>");
                            }
                            else
                            {
                                out.println("<li><a class=\"dropdown-item\" href=\"User?operation=HomePage\">My Profile</a></li>\n" +
                                            "<li><a class=\"dropdown-item\" href=\"User/Logout\">Log Out</a></li>");
                            }
                        %>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

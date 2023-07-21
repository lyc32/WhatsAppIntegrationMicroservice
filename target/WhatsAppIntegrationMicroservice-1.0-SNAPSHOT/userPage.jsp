<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" data-bs-theme="dark">
<head>
    <%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="header.jsp" %>
<%
    String operation = (String)request.getAttribute("operation");
    if(operation.equals("SignIn"))
    {
%>
<%@ include file="userPageSignIn.html" %>
<%
    }
    if(operation.equals("Login"))
    {
%>
<%@ include file="userPageLogin.html" %>
<%
    }
    if(operation.equals("HomePage"))
    {
%>
<%@ include file="userPageHome.jsp" %>
<%
    }
%>
<%@ include file="footer.jsp" %>
</body>
</html>

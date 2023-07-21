<%--
  Created by IntelliJ IDEA.
  User: Mac
  Date: 2023/7/21
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="head.jsp" %>
</head>
<body>

<div class="container mt-4 mb-4" style="min-height: 600px;">
    <div class="row justify-content-center">
        <div class="card" style="max-width: 600px;">
            <div class="row g-0">
                <form class="row g-3" >
                    <div class="card-body">
                        <h3 class="card-title text-center border-bottom  pb-4">Sign In</h3>
                        <p class="card-text pt-2 pb-2">
                        <div class="row">
                            <div class="col-sm-12">
                                <label for="firstName" class="col-form-label">User Name:</label>
                                <input type="text" class="form-control" name="firstName" id="firstName">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <label for="phone" class="col-form-label">Phone:</label>
                                <input type="text" class="form-control" name="phone" id="phone">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <label for="email" class="col-form-label">E-mail:</label>
                                <input type="text" class="form-control" name="email" id="email">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <label for="birthday" class="col-form-label">Date of Birth:</label>
                                <input type="text" class="form-control" name="birthday" id="birthday">
                            </div>
                        </div>
                        </p>

                        <p class="card-text pt-2 pb-2">
                        <div class="col-sm-12">
                            <label for="password" class="col-form-label">Password:</label>
                            <input type="password" class="form-control" name="password" id="password" onChange="onChange()">
                        </div>
                        <div class="col-sm-12">
                            <label for="confirm" class="col-form-label">Confirm Password:</label>
                            <input type="password" class="form-control" name="confirm" id="confirm" onChange="onChange()">
                        </div>
                        </p>

                        <p class="card-text pt-2 pb-2">
                        <div class="col-auto border-top mt-4 pt-4 text-center">
                            <input type="submit" class="btn btn-primary mb-3 btn-lg py-1 px-5 ms-4" value="next">
                            <input type="reset"  class="btn btn-primary mb-3 btn-lg py-1 px-5 ms-4" value="reset">
                        </div>
                        </p>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


</body>
</html>

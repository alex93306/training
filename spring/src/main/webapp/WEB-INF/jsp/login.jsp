<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 14.04.2015
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <link href="/css/styles.css" rel="stylesheet"/>
    <style>
        .tableDescription th {
            font-weight: normal;
            text-align: left;
        }
    </style>
</head>
<body>
<div class="wrapper">
    <form method="POST" action="/login">
        <label for="username">Username:</label>
        <input type="text" id="username"/>
        <label for="password">Password:</label>
        <input type="password" id="password"/>
        <input type="submit" value="Enter"/>
        <a href="#">I forgot password.</a>
        <a href="userEdit.jsp">Registration</a>
    </form>
</div>
</body>
</html>
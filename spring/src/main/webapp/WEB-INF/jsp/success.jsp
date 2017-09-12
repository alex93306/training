<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ALEX
  Date: 08.05.15
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
    <ul>
        <li>${user.username}</li>
        <li>${user.password}</li>
        <img src="${user.avatar}"/>
    </ul>
</div>
</body>
</html>

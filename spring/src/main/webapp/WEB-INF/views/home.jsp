<%--
  Created by IntelliJ IDEA.
  User: ALEX
  Date: 13.03.2016
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

 <ul id="container">

 </ul>
<button id="btn">Click me</button>
<script src="/resources/js/jquery-1.12.1.min.js"></script>
<script>
    var container=$('#container');
    $('#btn').click(function() {

       $.getJSON('/messages', function(result) {

           $.each(result.messageList, function(key, val) {
               $.each(val, function(k, v) {
                   $("<li id='" + k + "'>" + v + "</li>").appendTo(container);
               })
           })
        })
    });
</script>

</body>
</html>

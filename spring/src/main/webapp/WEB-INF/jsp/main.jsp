<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 11.05.2015
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<button id="showList">Show cities</button>
<div id="display"></div>
<script src="/resources/jquery-1.11.3.min.js"></script>
<script>
    var display =$('#display');
$('#showList').on('click', getAllCities);
    function getAllCities() {
        $.ajax({
            type: "GET",
            url: "/cityList",
            success: function(data) {
                display.html(data["name"]);
            }
        })
    }
</script>

</body>
</html>

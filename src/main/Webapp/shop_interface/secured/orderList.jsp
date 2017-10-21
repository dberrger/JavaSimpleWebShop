<%--
  Created by IntelliJ IDEA.
  User: sergi
  Date: 10/12/2017
  Time: 6:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
<head>
    <title>orderList</title>
    <meta http-equiv="content-type" content="text/html" charset="utf-8" />
</head>
<body>

<form name="orderForm" action="/OrderServlet" method="post" accept-charset="UTF-8">
    <p><b>Your name:</b><br>
        <input name="customer_name" type="text" size="40">
    </p>
    <p><b>Your address:</b><br>
        <input name="customer_address" type="text" size="40">
    </p>
    <input type="submit" value="Send">
</form>
</body>
</html>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: sergi
  Date: 10/9/2017
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<form action="j_security_check" method="post" name="loginForm">
    <input type="text" name="j_username">
    <input type="password" name="j_password">
    <input type="submit" value="log in">
</form>
</body>
</html>

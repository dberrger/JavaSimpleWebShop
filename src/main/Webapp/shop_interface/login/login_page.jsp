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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="../index_page/css/login.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

<jsp:include page="../index_page/header2.jsp"/>
<div class="w3-card-4 form_wrapper">
    <div class="w3-container w3-black">
        <h2 class="login_form">Login</h2>
    </div>
    <form class="w3-container" action="j_security_check" method="post" name="loginForm">
        <p>
            <label class="w3-text-brown"><b class="your_login_f">Your login</b></label>
            <input class="w3-input w3-border w3-sand" type="text" name="j_username"></p>
        <p>
            <label class="w3-text-brown"><b class="your_password_f">Your password</b></label>
            <input class="w3-input w3-border w3-sand" name="j_password" type="password"></p>
        <p>
            <input id="Register" class="w3-btn w3-brown" type="submit" value="Register"></p>
    </form>
</div>

<script type="text/javascript" src="../index_page/js/header_translater.js"></script>
<script type="text/javascript" src="../index_page/js/login_translater.js"></script>
</body>
</html>

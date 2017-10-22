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
    <title>Error!</title>
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
            <label class="w3-text-brown"><b class="error_login_1">Error! We suggest you to</b><a
                    href="../login/login_page.jsp" style="color:coral;"> <b class="error_login_2">try once again</b></a></label>
    </form>
</div>
<script type="text/javascript" src="../index_page/js/header_translater.js"></script>
<script type="text/javascript" src="../index_page/js/login_translater.js"></script>
</body>
</html>

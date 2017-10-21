<%--
  Created by IntelliJ IDEA.
  User: sergi
  Date: 10/9/2017
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your profile</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="../index_page/css/order_page.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<jsp:include page="../index_page/header.jsp"/>
<br>

<div id="languages">
    <a onclick="t('ru')">RU </a>
    <a onclick="t('en')">EN </a>
    <a onclick="t('de')">DE </a>
</div>

<div class="ordering">
    <h1 class="invite_msg">Hello, ${pageContext.request.userPrincipal.name}!</h1>
    <br>
    <div class="w3-bar w3-black  w3-light-grey">
        <button class="w3-bar-item w3-button" onclick="ajaxPOST()">basic info</button>
        <button class="w3-bar-item w3-button" onclick="basicInfo()">comments</button>
    </div>

    <div id="comments_wrapper" class="w3-container city">
        <div id="latest_comments_wrapper">
            <p>Last comments:</p><br>
            <div id="latest_comments_insert"></div>
        </div>
        <h1>Leave your comment:</h1>
        <textarea id="comment_text_area">

        </textarea>
        <a onclick="ajaxPOST('&all=1')">click </a>
    </div>

    <div id="basic_info_wrapper" class="w3-container city" style="display:none">
         stf
    </div>
</div>

<script src="secured_js/ajax_comments.js" type="text/javascript"></script>
</body>
</html>

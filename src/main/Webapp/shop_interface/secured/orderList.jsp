<%--
  Created by IntelliJ IDEA.
  User: sergi
  Date: 10/12/2017
  Time: 6:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
<head>
    <title>orderList</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="../index_page/css/order_page.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="https://api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript">
    </script>

    <script src="http://yandex.st/jquery/2.2.3/jquery.min.js" type="text/javascript"></script>


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
    <h1 class="order_header">Review your Order:</h1>
<div class="order_sum">Total price of your order is: ${sessionScope.sumOfCard}$</div>
    <br>
    <div class="w3-bar w3-black  w3-light-grey">
        <button class="w3-bar-item w3-button" onclick="delivery_case1()">courier</button>
        <button class="w3-bar-item w3-button" onclick="delivery_case2()">by yourself</button>
    </div>

    <div id="map_wrapper" class="w3-container city">
        <div id="map" style="width: 550px; height: 400px"></div>
    </div>

    <div id="courier_block_wrapper" class="w3-container city" style="display:none">
        <h2 class="courier_text">Write down your address...and our courier deviler your products <br>     <img src="../courier.png"></h2>
    </div>
    <div class="form_wrapper">
        <form class="order_form" name="orderForm" action="/OrderServlet" method="post">
            <p><b>Your name:</b><br>
                <input name="customer_name" type="text" size="40">
            </p>
            <p><b>Your address:</b><br>
                <input name="customer_address" id="address_form" type="text" size="40">
            </p>
            <input type="submit" value="Send">
        </form>
    </div>
</div>
</body>
<script src="secured_js/map.js" type="text/javascript"></script>
<script src="secured_js/order_tabs.js" type="text/javascript"></script>
</html>

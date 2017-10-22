<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/shop_interface/index_page/css/header-style.css">
    <link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
</head>
<body style="margin: -20px;">
<header class="header-login-signup">
    <div class="header-limiter">
        <h1><a href="/shop_interface/index_page/productList.jsp">Vinyl<span>shop</span></a></h1>
        <nav style="margin: -15px;">
            <a onclick="t('ru')">RU </a>
            <a onclick="t('en')">EN </a>
            <a onclick="t('de')">DE </a>
            <a href="/shop_interface/cart/cart.jsp"><img  src="/shop_interface/shopping_cart.png" width="15px" alt=""><span class="header_cart">Cart</span></a>
            <c:if test="${pageContext.request.isUserInRole('tomcat') && (not empty sessionScope.listOfProducts)}">
                <a id="order_red" href="/shop_interface/secured/orderList.jsp"><img src="/shop_interface/shopping_cart.png" width="15px" alt=""> <span class="header_order">Order</span></a>
            </c:if>
            <ul style="padding-top: 21px;">
                <c:choose>
                    <c:when test="${empty sessionScope.listOfProducts}">
                        <span class="empty_card_case"> Your card is empty</span>
                    </c:when>
                    <c:otherwise>
                        <c:out value="${sessionScope.productCount}"/> <span class="products_in_card">products in card.</span>
                        <c:out value="${sessionScope.sumOfCard}"/> $
                    </c:otherwise>
                </c:choose>
            </ul>
        </nav>
        <c:if test="${pageContext.request.isUserInRole('tomcat')}">
            <span class="header_hello">Hello, </span>${pageContext.request.userPrincipal.name}
            <br>
            <span class="header_your"> Your </span> <a class="header_profile" href="/shop_interface/secured/Profile.jsp" style="color: coral;">profile</a>
            <span class="header_you_can"> You can </span> <a class="header_log_out" href="/Invalidate">log out</a>
        </c:if>
        <c:if test="${not pageContext.request.isUserInRole('tomcat')}">
        <ul>
            <li><a href="/shop_interface/secured/Profile.jsp" class="header_login">Login</a></li>
        </ul>
        </c:if>
    </div>
</header>
<script type="text/javascript" src="js/traslater_product_list.js"></script>
</body>
</html>

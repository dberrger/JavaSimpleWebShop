<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login, Sign up Header</title>

    <link rel="stylesheet" href="/shop_interface/index_page/css/header-style.css">
    <link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
</head>
<body style="margin: -20px;">
<header class="header-login-signup">
    <div class="header-limiter">
        <h1><a href="/shop_interface/index_page/productList.jsp">Vinyl<span>shop</span></a></h1>
        <nav style="margin: -15px;">
            <a href="#" >Home</a>
            <a href="#">RU</a>
            <a href="#">EN</a>
            <a href="#">DE</a>
            <a href="#" >History <!-- for non registered user???? --></a>
            <a href="/shop_interface/cart/cart.jsp"><img  src="/shop_interface/shopping_cart.png" width="15px" alt="">Card</a>
            <a id="order_red" href="../cart/cart.jsp"><img src="/shop_interface/shopping_cart.png" width="15px" alt="">Order</a>
            <ul style="padding-top: 21px;">
                <c:choose>
                    <c:when test="${empty sessionScope.listOfProducts}">
                        Your card is empty
                    </c:when>
                    <c:otherwise>
                        <c:out value="${sessionScope.productCount}"/> products in card.
                        <c:out value="${sessionScope.sumOfCard}"/> $
                    </c:otherwise>
                </c:choose>
            </ul>
        </nav>

        <ul>
            <li><a href="#">Login</a></li>
            <li><a href="#">Sign up</a></li>
        </ul>
    </div>
</header>
</body>
</html>
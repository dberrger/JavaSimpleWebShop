<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="TestServlet.service.OrderBean" %>
<%@ page import="TestServlet.dao.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login, Sign up Header</title>

    <link rel="stylesheet" href="../index_page/css/header-style.css">
    <link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
</head>
<body>
<header class="header-login-signup">
    <div class="header-limiter">
        <h1><a href="#">Vinyl<span>shop</span></a></h1>
        <nav>
            <a href="#">Home</a>
            <a href="#">RU</a>
            <a href="#">EN</a>
            <a href="#">DE</a>
            <a href="#" >History <!-- for non registered user???? --></a>
            <a href="../cart/cart.jsp"><img src="../shopping_cart.png" width="15px" alt="shopping_cart">Card</a>
            <a id="order_red" href="../cart/cart.jsp"><img src="../shopping_cart.png" width="15px" alt="shopping_cart">Order</a>
        </nav>
        <ul>
            <% try{ArrayList<Product> bin = ((OrderBean) session.getAttribute("productToOrder")).getListOfProducts();
                pageContext.setAttribute("chill",bin);}
            catch (NullPointerException e){
                System.out.println("NPE");
            }%>

            <c:forEach varStatus="curr" var="item" items="${chill}">
                <c:out value="${item.album}"/>
                <c:out value="${item.artist}"/>
                <c:out value="${item.price}"/>
                <c:out value="${item.country}"/>
                <c:out value="${item.genre}"/> <br>
            </c:forEach>

        </ul>
        <ul>
            <li><a href="#">Login</a></li>
            <li><a href="#">Sign up</a></li>
        </ul>
    </div>
</header>
</body>
</html>

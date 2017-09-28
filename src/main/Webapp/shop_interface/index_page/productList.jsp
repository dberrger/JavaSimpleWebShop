<%@ page import="TestServlet.dao.DataBase" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="TestServlet.dao.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sergi
  Date: 9/14/2017
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>VinylShop</title>
    <jsp:useBean id="products" class="TestServlet.service.ProductManager" scope="session"/>
    <jsp:useBean id="db" class="TestServlet.dao.DataBase" scope="session"/>
    <jsp:useBean id="order" class="TestServlet.service.OrderBean" scope="session"/>
    <link rel="stylesheet" href="css/productList_style.css">
</head>
<body id="wrapper">

<jsp:include page="header.jsp"/>
<br>
<div id="languages">
    <a onclick="t('ru')">RU </a>
    <a onclick="t('en')">EN </a>
    <a onclick="t('de')">DE </a>
</div>
<div id="content_wrapper">
    <div id="filter_block">
        <p>Product filter..</p>
        <div>Sort by price ascending</div>
        <div>Sort by price descending</div>
        <div>Price
            <form>
                <input type="text" id="lowerBound">
                <input type="text" id="upperBound">
                <input type="button" value="send" onclick="productFilter('lowerBound','upperBound')"/>
            </form>
        </div>

    </div>

    <div id="product_list_block">

        <table id="item_list">
            <c:choose>
                <c:when test="${  pageContext.request.cookies[3].value.equals(\"t\")}">
                    <% Cookie cookie = null;
                        Cookie[] cookies = null;

                        // Get an array of Cookies associated with the this domain
                        cookies = request.getCookies();
                        if (cookies != null) {
                            out.println("<h2> Found Cookies Name and Value</h2>");
                            System.out.println(cookies.length);
                            for (int i = 0; i < cookies.length; i++) {
                                cookie = cookies[i];
                                out.print("Name : " + cookie.getName() + ",  ");
                                out.print("Value: " + cookie.getValue() + " <br/>");
                            }
                        } else {
                            out.println("<h2>No cookies founds</h2>");
                        }
                    %>
                    <c:forEach varStatus="curr" var="item"
                               items="${products.FilterByPriceRange(pageContext.request.cookies[1].value, pageContext.request.cookies[2].value)}">
                        <jsp:include page="insert_line.jsp">
                            <jsp:param name="artist" value="${item.artist}"/>
                            <jsp:param name="album" value="${item.album}"/>
                            <jsp:param name="year" value="${item.year}"/>
                            <jsp:param name="country" value="${item.country}"/>
                            <jsp:param name="genre" value="${item.genre}"/>
                            <jsp:param name="price" value="${item.price}"/>
                            <jsp:param name="album_cover" value="${item.album_cover}"/>
                        </jsp:include>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <c:forEach varStatus="curr" var="item" items="${products.products.productsBase}">
                        <jsp:include page="insert_line.jsp">
                            <jsp:param name="artist" value="${item.artist}"/>
                            <jsp:param name="album" value="${item.album}"/>
                            <jsp:param name="year" value="${item.year}"/>
                            <jsp:param name="country" value="${item.country}"/>
                            <jsp:param name="genre" value="${item.genre}"/>
                            <jsp:param name="price" value="${item.price}"/>
                            <jsp:param name="album_cover" value="${item.album_cover}"/>
                        </jsp:include>
                    </c:forEach>
                </c:otherwise>
            </c:choose>

        </table>
    </div>
</div>
<script type="text/javascript" src="js/productFilter.js"></script>
<script type="text/javascript" src="js/traslater_product_list.js"></script>
<script type="text/javascript" src="js/cardTransition.js"></script>
</body>
</html>

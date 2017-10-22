<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>VinylShop</title>
    <jsp:useBean id="products" class="TestServlet.service.ProductManager" scope="session"/>
    <jsp:useBean id="db" class="TestServlet.dao.DataBase" scope="session"/>
    <jsp:useBean id="orderEntity" class="TestServlet.service.OrderBean" scope="session"/>
    <jsp:useBean id="productInCard" class="TestServlet.service.Product" scope="session"/>

    <link rel="stylesheet" href="css/productList_style.css">
</head>
<body id="wrapper">

<jsp:include page="header.jsp"/>

<br>
<div id="languages">
    <a class="language_button" onclick="t('ru')">RU </a>
    <a class="language_button" onclick="t('en')">EN </a>
    <a class="language_button" onclick="t('de')">DE </a>
</div>
<div id="content_wrapper">
    <div id="filter_block">
        <p class="product_filter">Product filter by price</p>
        <div>
            <form>
                <input type="text" id="lowerBound">
                <input type="text" id="upperBound">
                <input type="button" value="OK" onclick="productFilter('lowerBound','upperBound')"/>
            </form>
        </div>

    </div>
</div>
    <div id="product_list_block">
        <table id="item_list">
${pageContext.request.cookies[0].value}
${pageContext.request.cookies[1].value}
${pageContext.request.cookies[2].value}
${pageContext.request.cookies[3].value}
${pageContext.request.cookies[4].value}
            <c:choose>
                <c:when test="${ pageContext.request.cookies[3].value.equals(\"t\")}">
                    <% //Uncomment for cookie debug
                         Cookie cookie = null;
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
                    <c:forEach varStatus="curr" var="item" items="${products.FilterByPriceRange(pageContext.request.cookies[1].value, pageContext.request.cookies[2].value)}">
                        <jsp:include page="insert_line.jsp">
                            <jsp:param name="ffs" value="${item.id}"/>
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
                            <jsp:param name="ffs" value="${item.id}"/>
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
<script type="text/javascript" src="js/addToCard.js"></script>
</body>
</html>

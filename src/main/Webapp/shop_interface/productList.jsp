<%@ page import="TestServlet.DataBase" %>
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
    <jsp:useBean id="products" class="TestServlet.ProductManager" scope="session"/>
    <link rel="stylesheet" type="text/css" href="style_header.css">
</head>
<body id="wrapper">
<div id="item_list_0"></div>
<div id="item_list_1"></div>
<div id="item_list_2"></div>
<div id="item_list_3"></div>
<div id="item_list_4"></div>
<jsp:include page="header.jsp"/> <br>
<table id="item_list">
<c:forEach var="item" items="${products.products.productsBase}">
   <jsp:include page="insert_line.jsp">
       <jsp:param name="brandName" value="${item.brandName}"/>
       <jsp:param name="price" value="${item.price}"/>
   </jsp:include>
</c:forEach>
</table>
<button onclick="productFilter(15)">filt</button>
<script type="text/javascript" src="../productFilter.js"></script>
</body>
</html>

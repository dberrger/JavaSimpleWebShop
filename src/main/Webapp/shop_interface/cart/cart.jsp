<%@ page import="TestServlet.service.OrderBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="TestServlet.dao.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <jsp:useBean id="Orbin" scope="application" class="TestServlet.service.OrderBean"/>
</head>
<body>
<% ArrayList<Product> bin = ((OrderBean) session.getAttribute("productToOrder")).getListOfProducts();%>
<% pageContext.setAttribute("chill",bin);
%>

<c:forEach varStatus="curr" var="item" items="${chill}">
   <c:out value="${item.album}"/> 
   <c:out value="${item.artist}"/>
   <c:out value="${item.price}"/>
   <c:out value="${item.country}"/>
   <c:out value="${item.genre}"/> <br>
</c:forEach>

</body>
</html>

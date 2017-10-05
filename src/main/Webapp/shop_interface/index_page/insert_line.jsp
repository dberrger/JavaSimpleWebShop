<%@ page import="TestServlet.service.OrderBean" %>
<%@ page import="TestServlet.dao.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/insert_line_style.css">

<jsp:useBean id="orderBean" class="TestServlet.service.OrderBean" scope="session"/>

    <tbody class="item">
    <td class="image_container" id="${param.ffs}" onclick="cardTransition(this.id)">
        <a class="image_box"  method="post">
            <img src="../${param.album_cover}.jpg" alt="picture_1" width="200px">
        </a>
    </td>
    <td id="product_description">
        <div id="description_container">
            <div style="width: 400px;">
                <span class="Artist"> Artist:</span>
                <span class="Artist_param"><c:out value="${param.artist}"/></span>
            </div>
            <div>
                <span class="Album"> Album:</span>
                 <span class="Album_param"><c:out value="${param.album}"/></span>
            </div>
            <div>
                <span class="Year"> Year:</span>
                <span class="Year_param"><c:out value="${param.year}"/></span>
            </div>
            <div>
                <span class="Country"> Country:</span>
                <span class="Country_param"><c:out value="${param.country}"/></span>
            </div>
            <div>
                <span class="Genre"> Genre:</span>
                <span class="Genre_param"><c:out value="${param.genre}"/></span>
            </div>
            <div>
                 <span class="Price"> Price:</span>
                <span class="Price_param"> <c:out value="${param.price}"/> </span>
            </div>
        </div>
    <td>

        <!-- !!!!!!!!!!!!!!!!!!!!!!!!!!! -->
        <button  id="${param.ffs}" class="add_to_card" onclick="addToCard(this.id) " >ADD TO CARD</button>
    </td>
    </tbody>


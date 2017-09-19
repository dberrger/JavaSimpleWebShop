<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sergi
  Date: 9/14/2017
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/insert_line_style.css">
<html>
<head>
    <title>Title</title>
</head>
<body>

    <tbody id="item">
    <td id="image_container">
        <a class="image_box" href="">
            <img src="../${param.album_cover}.jpg" alt="picture_1" width="200px">
        </a>
    </td>
    <td id="product_description">
        <div id="description_container">
            <div style="width: 400px;">
                <span class="Artist"> Artist:</span>
                <c:out value="${param.artist}"/>
            </div>
            <div>
                <span class="Album"> Album:</span>
                 <c:out value="${param.album}"/>
            </div>
            <div>
                <span class="Year"> Year:</span>
                 <c:out value="${param.year}"/>
            </div>
            <div>
                <span class="Country"> Country:</span>
                 <c:out value="${param.country}"/>
            </div>
            <div>
                <span class="Genre"> Genre:</span>
                 <c:out value="${param.genre}"/>
            </div>
            <div>
                <span class="Price"> Price:</span>

            </div>
            <div>
                <span class="zdarova"> <c:out value="${param.price}"/> </span>

            </div>
        </div>
    <td>
        <button class="add_to_card">ADD TO CARD</button>
    </td>

    </tbody>
</body>
</html>

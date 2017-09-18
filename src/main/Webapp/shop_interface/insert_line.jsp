<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sergi
  Date: 9/14/2017
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../style_inserted_page.css">
<html>
<head>
    <title>Title</title>
</head>
<body>

    <tbody id="item">
    <td id="image_container">
        <a class="image_box" href="">
            <img src="../1.jpg" alt="picture_1" width="200px">
        </a>
    </td>
    <td id="product_description">
        <div id="description_container">
            <div>
                <span id="Artist"> Artist:</span>
                <c:out value="${param.brandName}"/>
            </div>
            <div>
                <span id="Artist"> Price:</span>
                 <c:out value="${param.price}"/>
            </div>
        </div>
    <td>
        <button id="add_to_card">ADD TO CARD</button>
    </td>

    </tbody>

</body>
</html>

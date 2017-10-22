<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet" href="../index_page/css/productList_style.css">
    <link rel="stylesheet" href="../index_page/css/card.css">
    <jsp:useBean id="purchaseHistory" class="TestServlet.controller.History"/>
</head>
<body id="wrapper">
<jsp:include page="../index_page/header.jsp"/>
<br>

<jsp:include page="/History"/>
<div id="history_wrapper"><h1 class="Your_history">Your history:</h1></div>
<c:choose>
    <c:when test="${empty sessionScope.listOfProductsHistory}">
        <div id="empty_case_wrapper"><h1 id="empty_case" class="Your_history_empty">Your history is empty!</h1></div>
        <img id="sad_smile" src="../sad_smile.png">
    </c:when>
    <c:otherwise>
        <div id="content_wrapper">
            <div id="filter_block" style="visibility: hidden">
            </div>
            <div id="product_list_block"></div>
            <table id="cardTableList">
                <c:forEach varStatus="curr" var="item" items="${sessionScope.listOfProductsHistory}">
                    <tbody class="item">
                    <td class="image_container" id="${item.id}" onclick="cardTransition(this.id)">
                        <a class="image_box">
                            <img src="../${item.album_cover}.jpg" alt="picture_1" width="200px">
                        </a>
                    </td>
                    <td id="product_description">
                        <div id="description_container">
                            <div style="width: 400px;">
                                <span class="Artist"> Artist:</span>
                                <span class="Artist_item"><c:out value="${item.artist}"/></span>
                            </div>
                            <div>
                                <span class="Album"> Album:</span>
                                <span class="Album_item"><c:out value="${item.album}"/></span>
                            </div>
                            <div>
                                <span class="Year"> Year:</span>
                                <span class="Year_item"><c:out value="${item.year}"/></span>
                            </div>
                            <div>
                                <span class="Country"> Country:</span>
                                <span class="Country_item"><c:out value="${item.country}"/></span>
                            </div>
                            <div>
                                <span class="Genre"> Genre:</span>
                                <span class="Genre_item"><c:out value="${item.genre}"/></span>
                            </div>
                            <div>
                                <span class="Price"> Price:</span>
                                <span class="Price_item"> <c:out value="${item.price}"/> </span>
                            </div>
                        </div>
                    <td>
                        <div>
                            <span class="Quantity"> Quantity:</span>
                            <span class="Quantity_item">${sessionScope.listOfQuantitiesHistory.get((curr.index))} </span>
                        </div>
                        <div>
                            <span class="Date_purchase"> Date:</span>
                            <span class="Date_purchase_item">${sessionScope.dateTimesHistory.get((curr.index))} </span>
                        </div>
                    </td>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </c:otherwise>
</c:choose>
</body>
<script type="text/javascript" src="../index_page/js/cardTransition.js"></script>
<script src="../index_page/js/header_translater.js" type="text/javascript"></script>
<script src="../index_page/js/order_list_translater.js" type="text/javascript"></script>
<script src="../index_page/js/traslater_product_list.js" type="text/javascript"></script>
<script src="../index_page/js/purchase_history_translater.js" type="text/javascript"></script>
</html>
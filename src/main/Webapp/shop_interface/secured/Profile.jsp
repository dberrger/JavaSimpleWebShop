<%--
  Created by IntelliJ IDEA.
  User: sergi
  Date: 10/9/2017
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your profile</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="../index_page/css/myProfile.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<jsp:include page="../index_page/header.jsp"/>

<br>
<div class="ordering">
    <h1 class=" text_1"><span class="invite_msg">Hello,</span> ${pageContext.request.userPrincipal.name}!</h1>
    <span class="curr_time">Current time: </span>
    <div id="ctm"> </div>
    <br>
    <div class="text_1"><span class="link_on_purchaseHistory_1">You can look on your</span> <a
            class="link_on_purchaseHistory_2" href="../secured/purchaseHistory.jsp" style="color: coral;">latest
        purchases</a></div>
    <div class="comment_area_wrapper">
        <h1 class="text_1"><span class="leave_comment_line">Leave your comment:</span></h1>
        <textarea wrap="off" cols="30" rows="5" id="comment_text_area">

        </textarea>
        <a class="click_comment" onclick="ajaxPOST('&all=1')">click </a>
    </div>
    <div id="comments_wrapper" class="w3-container city">
        <div id="latest_comments_wrapper">
            <p class="text_1 "><span class="last_comments">Last comments:</span></p><br>
            <div id="latest_comments_insert"></div>
        </div>
        <div id="basic_info_wrapper" class="w3-container city" style="display:none">
            stf
        </div>
    </div>
</div>
<script src="secured_js/ajax_comments.js" type="text/javascript"></script>
<script src="secured_js/ajax_time.js" type="text/javascript"></script>
<script src="../index_page/js/header_translater.js" type="text/javascript"></script>
<script type="text/javascript" src="secured_js/myprofile_translater.js"></script>
<script type="text/javascript" src="../index_page/js/traslater_product_list.js"></script>
<script type="text/javascript" src="../index_page/js/purchase_history_translater.js"></script>
<script type="text/javascript" src="../index_page/js/order_list_translater.js"></script>
</body>
</html>

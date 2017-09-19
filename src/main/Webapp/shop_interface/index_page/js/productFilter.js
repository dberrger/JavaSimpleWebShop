function  productFilter(price){


    var request = new XMLHttpRequest();
    var url = "/productListServlet"+"?priceUnder="+price;
  //  var params = "priceUnder"+price;
    request.open("get", url, true);
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    request.onreadystatechange = function() {
        if (request.readyState == 4 && request.status == 200) {
            var responseData = JSON.parse(request.response);
           for(var o=0;o<3;o++){
           document.getElementById("item_list_"+o.toString()).innerHTML = responseData[o.toString()]
        }}
    }

request.send();
}



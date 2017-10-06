function addToCard(productID) {
 /*   var map = new Map();
    map.set("Hybrid Theory",0);
    map.set("Meteora",1);
    map.set("Minutes to Midnight",2);
    map.set("A Thousand Suns",3);
    map.set("Living Things",4);
    map.set("The Hunting Party",5);
    map.set("One More Light",6);*/
alert(productID);
    var request = new XMLHttpRequest();
    var url = "/ShoppingCardServlet" + "?productID="+productID;
    request.open("get", url, true);
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.onreadystatechange = function () {
        if (request.readyState == 4 && request.status == 200) {
            alert("OK?");

        }
    };
    request.send();
}
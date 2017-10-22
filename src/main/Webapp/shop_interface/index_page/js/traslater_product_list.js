function t(request_language) {
  //  alert(getCookie("lang_s"));
    var request = new XMLHttpRequest();
    var url = "/LangServlet";
    var params = "lang=" + request_language;
    console.log(request_language);
    request.open("post", url, true);
    // http.responseType = 'json';
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.onreadystatechange = function () {
        if (request.readyState == 4 && request.status == 200) {
            var responseData = JSON.parse(request.response);
          //  alert(request.response);

            var map = new Map();
            map.set(0, "Artist");
            map.set(1, "Album");
            map.set(2, "Year");
            map.set(3, "Genre");
            map.set(4, "Country");
            map.set(5, "Price");
            map.set(6, "add_to_card");
            map.set(7, "product_filter");
            map.set(8, "Quantity");
            map.set(9, "Current_price");
            map.set(10, "Total_cost");
            map.set(11, "Card_info");
            map.set(12, "Your_order");
            map.set(13, "product_filter");
            map.set(14, "empty_case");



            for (var i = 0; i < 7; i++) {
                for (var j = 0; j < 15; j++) {
                    if (document.getElementsByClassName(map.get(j))[i] === undefined) {
                        console.log("UNDEF!");
                    } else {
                        document.getElementsByClassName(map.get(j))[i].innerHTML = responseData[map.get(j)];
                    }
                }
            }
        }
    };

    request.send(params)
}
window.onload = t(getCookie("lang_s"));
function getCookie(name) {
    var matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}
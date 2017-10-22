function translate_order_list(request_language) {
    alert("Halooooooooooooooooooooooo"+request_language);
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
            alert(request.response);
            var map = new Map();
            map.set(0, "review_order");
            map.set(1, "total_price_msg");
            map.set(2, "by_courier");
            map.set(3, "by_yourself");
            map.set(4, "send_order");
            map.set(5, "your_name_order");
            map.set(6, "your_address_order");
            map.set(7, "courier_text");


            for (var j = 0; j < 8; j++) {
                if (document.getElementsByClassName(map.get(j))[0] === undefined) {
                    console.log("UNDEF!")
                } else {
                    document.getElementsByClassName(map.get(j))[0].innerHTML = responseData[map.get(j)];
                }
            }
        }

        document.getElementById("submit_button").value = responseData["send_order"];
    };
    request.send(params);
}

window.onload = translate_order_list(getCookie("lang_s"));
function getCookie(name) {
    var matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}
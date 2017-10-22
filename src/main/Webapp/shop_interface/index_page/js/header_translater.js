function translate_header(request_language) {
    //alert("Halo"+request_language);
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
            //alert(request.response);
            var map = new Map();
            map.set(0, "header_cart");
            map.set(1, "header_order");
            map.set(2, "header_hello");
            map.set(3, "header_your");
            map.set(4, "header_profile");
            map.set(5, "header_you_can");
            map.set(6, "header_log_out");
            map.set(7, "header_log_out");
            map.set(8, "Current_price");
            map.set(9, "header_login");
            map.set(10, "empty_card_case");
            map.set(11, "products_in_card");


                for (var j = 0; j < 12; j++) {
                    if (document.getElementsByClassName(map.get(j))[0] === undefined) {
                        console.log("UNDEF!")
                    } else {
                        document.getElementsByClassName(map.get(j))[0].innerHTML = responseData[map.get(j)];
                    }
                }
            }


    };
    request.send(params);
}

window.onload = translate_header(getCookie("lang_s"));
function getCookie(name) {
    var matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}
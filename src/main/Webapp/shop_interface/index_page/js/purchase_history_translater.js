function translate_purchase_history(request_language) {
    alert(getCookie("lang_s"));
    var request = new XMLHttpRequest();
    var url = "/LangServlet";
    var params = "lang=" + request_language;
    console.log(request_language);
    request.open("post", url, true);
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.onreadystatechange = function () {
        if (request.readyState == 4 && request.status == 200) {
            var responseData = JSON.parse(request.response);
            alert(request.response);

            var map = new Map();
            map.set(0, "Artist");
            map.set(1, "Album");
            map.set(2, "Year");
            map.set(3, "Genre");
            map.set(4, "Country");
            map.set(5, "Price");
            map.set(6, "Quantity");
            map.set(7, "Date_purchase");
            map.set(8, "Your_history");
            map.set(9, "Your_history_empty");



            for (var i = 0; i < 40; i++) {
                for (var j = 0; j < 10; j++) {
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
window.onload = translate_purchase_history(getCookie("lang_s"));
function getCookie(name) {
    var matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}
function translate_login(request_language) {
    //alert("Halooooooooooooooooooooooo"+request_language);
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
            map.set(0, "your_password_f");
            map.set(1, "your_login_f");
            map.set(2, "login_form");
            map.set(3, "error_login_1");
            map.set(4, "error_login_2");
            map.set(5, "Register");


            for (var j = 0; j < 5; j++) {
                if (document.getElementsByClassName(map.get(j))[0] === undefined) {
                    console.log("UNDEF!")
                } else {
                    document.getElementsByClassName(map.get(j))[0].innerHTML = responseData[map.get(j)];
                }
            }
        }

        document.getElementById("Register").value = responseData["Register"];
    };
    request.send(params);
}

window.onload = translate_login(getCookie("lang_s"));
function getCookie(name) {
    var matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}
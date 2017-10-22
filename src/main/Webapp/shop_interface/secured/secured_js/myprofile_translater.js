
function translate_myprofile(request_language) {
   // alert(getCookie("lang_s"));
    var request = new XMLHttpRequest();
    var url = "/LangServlet";
    var params = "lang=" + request_language;
    console.log(request_language);
    request.open("post", url, true);
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.onreadystatechange = function () {
        if (request.readyState == 4 && request.status == 200) {
            var responseData = JSON.parse(request.response);
           // alert(request.response);

            var map = new Map();
            map.set(0, "invite_msg");
            map.set(1, "link_on_purchaseHistory_1");
            map.set(2, "link_on_purchaseHistory_2");
            map.set(3, "leave_comment_line");
            map.set(4, "last_comments");
            map.set(5, "click_comment");
            map.set(6, "curr_time");


                for (var j = 0; j < 7; j++) {
                    if (document.getElementsByClassName(map.get(j))[0] === undefined) {
                        console.log("UNDEF!");
                    } else {
                        document.getElementsByClassName(map.get(j))[0].innerHTML = responseData[map.get(j)];
                    }

            }
        }
    };

    request.send(params)
}
window.onload = translate_myprofile(getCookie("lang_s"));
function getCookie(name) {
    var matches = document.cookie.match(new RegExp("(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}
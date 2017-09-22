function t(request_language) {

    var request = new XMLHttpRequest();
    var url = "/Servlet";
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
            map.set(0, "Artist");
            map.set(1, "Album");
            map.set(2, "Year");
            map.set(3, "Genre");
            map.set(4, "Country");
            map.set(5, "Price");
            map.set(6, "add_to_card");
            map.set(7, "zdarova");
            for(var i=0;i<7;i++) {
                for (var j = 0; j < 7; j++) {
                document.getElementsByClassName(map.get(j))[i].innerHTML = responseData[map.get(j)];
                }
            }
        }
    }

    request.send(params)
}
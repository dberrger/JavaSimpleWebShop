function  func(request_language){
    var request = new XMLHttpRequest();
    var url = "/LangServlet";
    var params = "lang="+request_language;
    console.log(request_language);
    request.open("post", url, true);
   request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.onreadystatechange = function() {
        if(request.readyState == 4 && request.status == 200) {

            var responseData = JSON.parse(request.response);
            translate(responseData);
        }
    }
    request.send(params);
}

function translate(responseData) {
    var map = new Map();
    map.set(0,"Quick view");
    map.set(1,"Reviews");
    map.set(2,"More info");
    map.set(3,"add_to_card");

    map.set(4,"Artist");
    map.set(5,"Album");
    map.set(6,"Year");
    map.set(7,"Country");
    map.set(8,"Genre");
    map.set(9,"Price");
    for(var i = 0; i<map.size; i++) {
        document.getElementsByClassName(map.get(i))[0].innerHTML = responseData[map.get(i)];
    }
}


function text1() {
    document.getElementById("shop").innerHTML = " 111111111111111111111!";
}
function text2() {
    document.getElementById("shop").innerHTML = " 2222222222222222222";
}
function text3() {
    document.getElementById("shop").innerHTML = " 3333333333333333333";
}


function  init(){

    var request = new XMLHttpRequest();
    var url = "/TabServlet";
    var params = "";
    request.open("post", url, true);
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    request.onreadystatechange = function() {
        if(request.readyState == 4 && request.status == 200) {
            var responseData= JSON.parse(request.response);

            if(responseData["default_tab"]==="1"){
                window.onload = text1();
            }
            else if (responseData["default_tab"]==="2") {
                window.onload = text2();
            }
            else if (responseData["default_tab"]==="3") {
                window.onload = text3();
        }}
    }

    request.send(params);
}


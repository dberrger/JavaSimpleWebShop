function quickReview() {
    document.getElementById("shop").style.display = "block";
    document.getElementById("info").style.display = "none";
}
function reviews() {
    document.getElementById("info").style.display = "block";
   document.getElementById("info").innerHTML = " Отзывы" ;
   document.getElementById("shop").style.display = "none";
}
function moreInfo() {
    document.getElementById("info").style.display = "block";
    document.getElementById("info").innerHTML = " Подробно";
    document.getElementById("shop").style.display = "none";
}


function  init(defParam){
   /* var request = new XMLHttpRequest();
    var url = "/TabServlet";
    var params = "";
    request.open("post", url, true);
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    request.onreadystatechange = function() {
        if(request.readyState == 4 && request.status == 200) {
            var responseData= JSON.parse(request.response);

            if(responseData["default_tab"]==="1"){
                window.onload = quickReview();
            }
            else if (responseData["default_tab"]==="2") {
                window.onload = reviews();
            }
            else if (responseData["default_tab"]==="3") {
                window.onload = moreInfo();
        }}
    }

    request.send(params);*/


    if(defParam===1){
        quickReview();
    }
    else if (defParam===2) {
       reviews();
    }
    else if (defParam===3) {
        moreInfo();
    }
}


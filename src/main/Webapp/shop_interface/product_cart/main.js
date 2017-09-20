

function  func(request_language){
    var request = new XMLHttpRequest();
    var url = "/Servlet";
    var params = "lang="+request_language;
    console.log(request_language);
    request.open("post", url, true);
   // http.responseType = 'json';
   request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.onreadystatechange = function() {
        if(request.readyState == 4 && request.status == 200) {

            var responseData = JSON.parse(request.response);

//TODO переписать
           document.getElementById("Quick view").innerHTML = responseData["Quick view"];
           document.getElementById("Reviews").innerHTML = responseData["Reviews"];
           document.getElementById("More info").innerHTML = responseData["More info"];
           document.getElementById("add_to_card").innerHTML = responseData["add_to_card"];

           document.getElementById("Artist").innerHTML = responseData["Artist"];
           document.getElementById("Album").innerHTML = responseData["Album"];
           document.getElementById("Label").innerHTML = responseData["Label"];
           document.getElementById("Year").innerHTML = responseData["Year"];
           document.getElementById("Country").innerHTML = responseData["Country"];
           document.getElementById("Type").innerHTML = responseData["Type"];
           document.getElementById("Format").innerHTML = responseData["Format"];
           document.getElementById("Condition").innerHTML = responseData["Condition"];
           document.getElementById("Genre").innerHTML = responseData["Genre"];
           document.getElementById("Available").innerHTML = responseData["Available"];

        }
    }
    request.send(params);



}

//window.onload = func("en");
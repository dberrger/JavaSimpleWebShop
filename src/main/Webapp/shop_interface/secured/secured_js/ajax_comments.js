function addComment(content) {
for(var i=0; i< Object.keys(content).length; i++) {
    var divToInsert = document.createElement("div");
    var divToInsert1 = document.createElement("div");
    var hr = document.createElement("hr");
    divToInsert.innerHTML = content[i][0];
    divToInsert1.innerHTML = content[i][1];

    document.getElementById("latest_comments_insert").appendChild(divToInsert);
    document.getElementById("latest_comments_insert").appendChild(divToInsert1);
    document.getElementById("latest_comments_insert").appendChild(hr);
}
}


function ajaxPOST(extra_value) {
    alert(extra_value);
    var params = "params="+document.getElementById("comment_text_area").value+extra_value;

    alert(params);
    //var f = callback || function (data) {};
    alert("!hello ");
    var request = new XMLHttpRequest();
    var url = "/CommentHandler";

    request.onreadystatechange = function () {
        if (request.readyState == 4 && request.status == 200) {
            alert("OK");
            alert(request.response);
            var responseData = JSON.parse(request.response);
           addComment(responseData);

        }
    };
    request.open("post", url);
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.send(params);
}

function basicInfo() {

}

window.onload = ajaxPOST("&all=all");
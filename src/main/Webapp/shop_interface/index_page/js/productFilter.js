function getParentElement() {
    document.getElementById("item_list");
    return table;
}

function createRow(counter) {
    var clnNode = document.getElementsByTagName("tbody")[0].cloneNode(true);
    return clnNode;
}

function appendNode(table) {
    table.appendChild(clnNode);
}

function useFilter(responseData) {
    var map = new Map();
    map.set(0, "Artist_param");
    map.set(1, "Album_param");
    map.set(2, "Year_param");
    map.set(3, "Genre_param");
    map.set(4, "Country_param");
    map.set(5, "Price_param");
    var table = document.getElementById("item_list");
    var array = [];
    for (var counter = 0; counter < Object.keys(responseData).length; counter++) {
        array.push(createRow(counter));
    }

    var s = document.getElementById("item_list").getElementsByTagName("tbody").length;
    for (var o = 0; o < s; o++) {
        document.getElementsByClassName("item")[0].remove();
    }

    for (var i = 0; i < Object.keys(responseData).length; i++) {
        for (var j = 0; j < 6; j++) {
            array[i].getElementsByClassName(map.get(j))[0].innerHTML = responseData[i][j];


        }

        array[i].getElementsByClassName("image_container")[0].innerHTML = "<img src=\"../" +
            responseData[i][6] +
            ".jpg\" alt=\"picture_1\" width=\"200px\">";
        var currID = responseData[i][1].toString();
        array[i].getElementsByClassName("add_to_card")[0].setAttribute("id", currID);
        table.appendChild(array[i]);
    }
}

function productFilter(lowerBound, upperBound) {


    var lbound = document.getElementById(lowerBound).value;
    var ubound = document.getElementById(upperBound).value;
    var request = new XMLHttpRequest();
    var url = "/FilterServlet" + "?lowerBound=" + lbound + "&upperBound=" + ubound + "&bua=t";
    request.open("get", url, true);
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.onreadystatechange = function () {
        if (request.readyState == 4 && request.status == 200) {
            alert(request.response);
            var responseData = JSON.parse(request.response);
            alert(request.response);
            useFilter(responseData);
        }

    };
    request.send();
}



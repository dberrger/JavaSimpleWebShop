function addRow(){
    var table=document.getElementById("item_list");
    var clnNode=document.getElementsByTagName("tbody")[0].cloneNode(true);
    clnNode.getElementsByClassName("Artist")[0].innerHTML = "`~`!`~`";
    table.insertBefore(clnNode,table.lastChild);

   // clnNode.getElementsByClassName("item")[0].display.style = "block";
}

function  productFilter(lowerBound, upperBound){


   var lbound = document.getElementById(lowerBound).value;
   var ubound = document.getElementById(upperBound).value;
//TODO написать функцию для длины jsona filter
    var request = new XMLHttpRequest();
    var url = "/productListServlet"+"?lowerBound="+lbound+"&upperBound="+ubound;
    request.open("get", url, true);
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.onreadystatechange = function() {
        if (request.readyState == 4 && request.status == 200) {

            var map = new Map();
            map.set(0,"Artist");
            map.set(1,"Album");
            map.set(2,"Year");
            map.set(3,"Genre");
            map.set(4,"Country");
            map.set(5, "Price");
            map.set(6, "add_to_card");
            map.set(7, "zdarova");


            var responseData = JSON.parse(request.response);
            var clone= [];

            addRow();
            for(var o=0;o<7;o++) {
                document.getElementsByClassName("item")[0].remove();
            }
            alert(clone.length);
            alert(Object.keys(responseData).length);






/*
            for(var x=0;x<Object.keys(responseData).length;x++) {
               // clone[x].getElementsByClassName('Artist')[x].innerHTML = "Veeeeeeeeee   ";
                document.getElementById("item_list").appendChild(clone[x]);
            }
*/
        }

    }

request.send();
}



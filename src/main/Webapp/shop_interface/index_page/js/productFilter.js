function createRow(counter){
   // var table=document.getElementById("item_list");
    var clnNode=document.getElementsByTagName("tbody")[0].cloneNode(true);
    clnNode.getElementsByClassName("Artist")[0].innerHTML = counter;
return clnNode;

   // clnNode.getElementsByClassName("item")[0].display.style = "block";
}
function appendNode(table) {
    table.appendChild(clnNode);
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
            var responseData = JSON.parse(request.response);
            var map = new Map();
            map.set(0,"Artist");
            map.set(1,"Album");
            map.set(2,"Year");
            map.set(3,"Genre");
            map.set(4,"Country");
            map.set(5, "Price");
            map.set(6, "add_to_card");
            map.set(7, "zdarova");
            alert("Count of received rows "+Object.keys(responseData).length);
            var table=document.getElementById("item_list");
            var array =[];
            for(var counter=0;counter<Object.keys(responseData).length;counter++){
                array.push(createRow(counter));
            }

            alert("b4 "+document.getElementById("item_list").getElementsByTagName("tbody").length);
            var s = document.getElementById("item_list").getElementsByTagName("tbody").length;
            for(var o=0;o<s;o++) {
                document.getElementsByClassName("item")[0].remove();
            }


            for(var counter1=0;counter1<Object.keys(responseData).length;counter1++){
                array[counter1].getElementsByClassName("image_container")[0].innerHTML = "<img src=\"../"+counter1+".jpg\" alt=\"picture_1\" width=\"200px\">";
                table.appendChild(array[counter1]);
            }


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



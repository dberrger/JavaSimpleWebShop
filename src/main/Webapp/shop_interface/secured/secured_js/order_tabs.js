function delivery_case1() {
    //document.getElementById("adr").innerHTML = "Shop address: ";
    document.getElementById("map_wrapper").style.display = "block";
    document.getElementById("courier_block_wrapper").style.display = "none";
}
function delivery_case2() {
    //document.getElementById("adr").innerHTML = "Your address: ";
    document.getElementById("courier_block_wrapper").style.display = "block";

    //document.getElementById("courier_block").innerHTML = "courier" ;
    document.getElementById("map_wrapper").style.display = "none";
}
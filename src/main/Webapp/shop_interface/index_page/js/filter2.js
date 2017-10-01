function foo(a) {
  //  alert("Hello "+a);

    var div = document.createElement("div");
    div.innerHTML = a;
    document.getElementById("aveMariia").insertBefore(div,null);
}
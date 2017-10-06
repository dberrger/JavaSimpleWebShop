function cardTransition(list) {

alert(list);

    window.location ="http://localhost:8080/TabServlet?productID="+ list;
    alert(list);
    /*  var request = new XMLHttpRequest();
      var url = "/TabServlet" + "?productID="+list;
      request.open("get", url, true);
      request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
      request.onreadystatechange = function () {
          if (request.readyState == 4 && request.status == 200) {
              window.location ="http://localhost:8080/TabServlet?productID="+list;

          }
      };
      request.send();
  */
}
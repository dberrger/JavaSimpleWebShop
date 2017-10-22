function showClock() {
    var obj = document.getElementById('ctm');
    var req;

    if (window.XMLHttpRequest)	req = new XMLHttpRequest();
    else if(window.ActiveXObject) {
        try {
            req = new ActiveXObject('Msxml2.XMLHTTP');
        } catch (e){}
        try {
            req = new ActiveXObject('Microsoft.XMLHTTP');
        } catch (e){}
    }

    if (req) {
        req.onreadystatechange = function() {
            if (req.readyState == 4 && req.status == 200)
            { obj.innerHTML = req.responseText; }
        };
        req.open("POST", '/TimeServlet', true);
        req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        req.send('clock=1&ajax=1');
    }
    else alert("������� �� ������������ AJAX");
}

setInterval(showClock, 1000);
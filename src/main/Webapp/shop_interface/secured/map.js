ymaps.ready(init);
var map, myPlacemark, myPlacemark1, myPlacemark2;
function init() {
     map = new ymaps.Map("map", {
        center: [55.76, 37.64],
        zoom: 5
    });
    myPlacemark = new ymaps.Placemark([55.76, 37.64], {
        balloonContentBody: [
            '<address>',
            '<strong>VinylShop 1</strong>',
            '<br/>',
            'Адрес: 119021, Москва, ул. Льва Толстого, 16',
            '<br/>',

            '</address>'
        ].join('')
    }, {
        preset: 'islands#redDotIcon'
    });

    myPlacemark1 = new ymaps.Placemark([60.78, 29.64], {
        balloonContentBody: [
            '<address>',
            '<strong>VinylShop 2</strong>',
            '<br/>',
            'Адрес: 119021, Дебри, ул. Льва Толстого, 112321',
            '<br/>',

            '</address>'
        ].join('')
    }, {
        preset: 'islands#redDotIcon'
    });

    myPlacemark2 = new ymaps.Placemark([56.80, 30.64], {
        balloonContentBody: [
            '<address>',
            '<strong>VinylShop 3</strong>',
            '<br/>',
            'Адрес: 119021, Москва, ул.  Не Льва Толстого, 112312',
            '<br/>',

            '</address>'
        ].join('')
    }, {
        preset: 'islands#redDotIcon'
    });

    myPlacemark.events.add('click', function (e) {
        document.getElementById("address_form").value = "Адрес: 119021, Москва, ул. Льва Толстого, 16";
    });
    myPlacemark1.events.add('click', function (e) {
        document.getElementById("address_form").value = "Соломовой 139а";
    });
    myPlacemark2.events.add('click', function (e) {
        document.getElementById("address_form").value = "Nekrasova 23";
    });

    map.geoObjects.add(myPlacemark);
    map.geoObjects.add(myPlacemark1);
    map.geoObjects.add(myPlacemark2);


}


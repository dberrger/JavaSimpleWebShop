package TestServlet.controller;

import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;



@javax.servlet.annotation.WebServlet(name = "LangServlet")
public class LangServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JSONObject en_content = new JSONObject();
        JSONObject ru_content = new JSONObject();
        JSONObject de_content = new JSONObject();
        Cookie c = new Cookie("lang_s", request.getParameter("lang"));
        response.addCookie(c);
        en_content.put("zdarova", "cheto na englishe");
        ru_content.put("zdarova", "цена");
        de_content.put("zdarova", "preis");

//TODO rewrite;
        ru_content.put("Quick view", "Кратко");
        ru_content.put("More info", "Подробнее");
        ru_content.put("Reviews", "Отзывы");
        ru_content.put("add_to_card", "Добавить в корзину");

        ru_content.put("Artist", "Исполнитель: ");
        ru_content.put("Album", "Альбом: ");
        ru_content.put("Label", "Лейбл: ");
        ru_content.put("Year", "Год издательства: ");
        ru_content.put("Country", "Страна: ");
        ru_content.put("Type", "Тип: ");
        ru_content.put("Format", "Формат: ");
        ru_content.put("Condition", "Состояние: ");
        ru_content.put("Genre", "Жанр: ");
        ru_content.put("Available", "В наличии: ");
        ru_content.put("Price", "Стоимость:");

        ru_content.put("Quantity", "Количество: ");
        ru_content.put("Current_price", "Цена: ");
        ru_content.put("Total_cost", "Цена заказа:");
        ru_content.put("Card_info", "продуктов в корзине");
        ru_content.put("Your_order", "Ваш заказ:");


        ru_content.put("Date_purchase", "Дата заказа:");
        ru_content.put("Your_history", "История ваших покупок");
        ru_content.put("Your_history_empty", "Вы еще ничего не приобрели!");

        //Header
        ru_content.put("product_filter","Фильтр продуктов (по цене): ");
        ru_content.put("header_cart","Корзина ");
        ru_content.put("header_order","Заказ ");
        ru_content.put("header_hello","Привет, ");
        ru_content.put("header_your","Ваш ");
        ru_content.put("header_profile","кабинет ");
        ru_content.put("header_you_can","Вы можете ");
        ru_content.put("header_log_out","выйти ");
        ru_content.put("header_login","Войти ");
        ru_content.put("empty_card_case", "Ваша корзина пуста. ");
        ru_content.put("products_in_card", " продуктов в корзине. ");

        ru_content.put("empty_case", "Ваша корзина пуста! ");

        ru_content.put("your_address_order", "Ваш адрес: ");
        ru_content.put("your_name_order", "Ваше имя: ");
        ru_content.put("review_order", "Оформление заказа: ");
        ru_content.put("total_price_msg", "Общая стоимость заказа: ");
        ru_content.put("by_courier", "Доставить курьером ");
        ru_content.put("by_yourself", "Самовывоз ");
        ru_content.put("send_order", "Оформить заказ");
        ru_content.put("courier_text", "Напишите ваш адрес и наш курьер доставит все вовремя..");

        //Profile
        ru_content.put("invite_msg", "Добро пожаловать, ");
        ru_content.put("link_on_purchaseHistory_1", "Вы можете посмотреть ");
        ru_content.put("link_on_purchaseHistory_2", "историю своих покупок ");
        ru_content.put("leave_comment_line", "Оставьте Ваш комментарий: ");
        ru_content.put("click_comment", "Отправить");
        ru_content.put("last_comments", "Последние комментарии: ");
        ru_content.put("curr_time", "Текущее время: ");

        //Login
        ru_content.put("your_password_f", "Введите пароль: ");
        ru_content.put("your_login_f", "Введите логин: ");
        ru_content.put("login_form", "Вход в систему ");
        ru_content.put("error_login_1", "Ошибка! мы предлагаем Вам попробовать ");
        ru_content.put("error_login_2", " еще раз ");
        ru_content.put("Register", " Войти ");



        de_content.put("Quick view", "Kurz");
        de_content.put("More info", "mehr");
        de_content.put("Reviews", "Bewertungen");
        de_content.put("add_to_card", "In den Warenkorb");

        de_content.put("Artist", "Performer: ");
        de_content.put("Album", "Album: ");
        de_content.put("Label", "Kennzeichnen: ");
        de_content.put("Year", "Jahr des Verlagshauses: ");
        de_content.put("Country", "Land: ");
        de_content.put("Type", "Typ: ");
        de_content.put("Format", "Formatieren: ");
        de_content.put("Condition", "Zustand: ");
        de_content.put("Genre", "Genre: ");
        de_content.put("Available", "Auf Lager: ");
        de_content.put("Price", "Preis: ");

        de_content.put("Quantity", "Anzahl der: ");
        de_content.put("Current_price", "Preis: ");
        de_content.put("Total_cost", "Auftragspreis:");
        de_content.put("Card_info", "produkte in warenkorb.");
        de_content.put("Your_order", "Ihre Bestellung: ");

        //Header
        de_content.put("product_filter","Produktfilter (preis): ");
        de_content.put("header_cart","Einkaufswagen ");
        de_content.put("header_order","Bestellen ");
        de_content.put("header_hello","Hallo, ");
        de_content.put("header_your","Ihre ");
        de_content.put("header_profile","Zimmer ");
        de_content.put("header_you_can","Sie können ");
        de_content.put("header_log_out","beenden ");
        de_content.put("header_login","Einloggen ");
        de_content.put("empty_card_case", "Nein producte ");
        de_content.put("products_in_card", "Produkte im Warenkorb ");

        de_content.put("empty_case", "Nein producte! ");

        //OrderLuist
        de_content.put("your_address_order", "Versandadresse: ");
        de_content.put("your_name_order", "Ihr Name: ");
        de_content.put("review_order", "Bestellen: ");
        de_content.put("total_price_msg", "Auftragskosten: ");
        de_content.put("by_courier", "Lieferung per Kurier ");
        de_content.put("by_yourself", "Abholung ");
        de_content.put("send_order", "Eine Bestellung aufgeben");
        de_content.put("courier_text", "Schreiben Sie Ihre Adresse auf ... und unser Kurier deviler Ihre Produkte ..");

        de_content.put("Date_purchase", "Bestelldatum:");

        //Profile
        de_content.put("invite_msg", "Willkommen zurück, ");
        de_content.put("link_on_purchaseHistory_1", "Du kannst sehen ");
        de_content.put("link_on_purchaseHistory_2", "Geschichte ihrer Einkäufe ");
        de_content.put("leave_comment_line", "Hinterlassen Sie Ihren Kommentar: ");
        de_content.put("click_comment", "Senden");
        de_content.put("last_comments", "Letzte Kommentare: ");
        de_content.put("curr_time", "Gegenwart: ");
        //Login
        de_content.put("your_password_f", "Passwort: ");
        de_content.put("your_login_f", "Login: ");
        de_content.put("login_form", "Anmeldung im System ");
        de_content.put("error_login_1", "Fehler! Wir schlagen vor, dass Sie  ");
        de_content.put("error_login_2", " es erneut versuchen ");
        de_content.put("Register", " einloggen ");


        en_content.put("Quick view", "Quick view");
        en_content.put("More info", "More info");
        en_content.put("Reviews", "Reviews");
        en_content.put("add_to_card", "Add to card");

        en_content.put("Artist", "Artist: ");
        en_content.put("Album", "Album: ");
        en_content.put("Label", "Label: ");
        en_content.put("Year", "Year: ");
        en_content.put("Country", "Country: ");
        en_content.put("Type","Type");
        en_content.put("Format", "Format: ");
        en_content.put("Condition", "Condition: ");
        en_content.put("Genre", "Genre: ");
        en_content.put("Available", "Available: ");
        en_content.put("Price", "Price: ");

        en_content.put("Quantity", "Quantity: ");
        en_content.put("Current_price", "Current price: ");
        en_content.put("Total_cost", "Total cost:");
        en_content.put("Card_info", "products in the card.");
        en_content.put("Your_order", "Your order: ");

        de_content.put("Date_purchase", "Date de: ");
        de_content.put("Your_history", "Ihre Geschichte");
        de_content.put("Your_history_empty", "Du hast noch nichts gekauft!");

        //Header
        en_content.put("product_filter","Product filter(by price): ");
        en_content.put("header_cart","Cart ");
        en_content.put("header_order","Order ");
        en_content.put("header_hello","Hello, ");
        en_content.put("header_your","Your ");
        en_content.put("header_profile","profile ");
        en_content.put("header_you_can","You can ");
        en_content.put("header_log_out","log out ");
        en_content.put("header_login","Login ");
        en_content.put("empty_card_case", "Your card is empty ");
        en_content.put("products_in_card", "products in card. ");
        en_content.put("empty_case", "Your card is empty! ");

        en_content.put("Date_purchase", "Date: ");
        en_content.put("Your_history", "Your history");
        en_content.put("Your_history_empty", "You haven't but anything yet!");
        //Cart

        //MyProfile
        en_content.put("invite_msg", "Hello, ");
        en_content.put("link_on_purchaseHistory_1", "You can look on your ");
        en_content.put("link_on_purchaseHistory_2", "latest purchases ");
        en_content.put("leave_comment_line", "Leave your comment: ");
        en_content.put("click_comment", "Send");
        en_content.put("last_comments", "Last comments: ");
        en_content.put("curr_time", "Current time: ");
        //Login
        en_content.put("your_password_f", "Password: ");
        en_content.put("your_login_f", "Login: ");
        en_content.put("login_form", "Entering ");
        en_content.put("error_login_1", "Error! We suggest to you ");
        en_content.put("error_login_2", " try once again ");
        en_content.put("Register", " sign in ");
        //LoginError
        //OrderList
        en_content.put("your_address_order", "Your address: ");
        en_content.put("your_name_order", "Your name: ");
        en_content.put("review_order", "Review your Order: ");
        en_content.put("total_price_msg", "Total price of your order is: ");
        en_content.put("by_courier", "Deliver by courier ");
        en_content.put("by_yourself", "Deliver by yourself ");
        en_content.put("send_order", "Send");
        en_content.put("courier_text", "Write down your address...and our courier deviler your products.. ");


        //purchaseHistory

        String request_language = request.getParameter("lang");



        System.out.println(request_language);


        response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();

            if (request_language.equals("ru")) {
                printWriter.println(ru_content);
            } else if (request_language.equals("en")) {
                printWriter.println(en_content);

            } else if (request_language.equals("de")) {
                printWriter.println(de_content);
            }
        }




    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("123");


    }
}

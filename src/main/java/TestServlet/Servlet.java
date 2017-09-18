package TestServlet;

import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



@javax.servlet.annotation.WebServlet(name = "Servlet")
public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {





        JSONObject en_content = new JSONObject();
        JSONObject ru_content = new JSONObject();
        JSONObject de_content = new JSONObject();


//TODO rewrite ;
        ru_content.put("Quick view", "Кратко");
        ru_content.put("More info", "Подробнее");
        ru_content.put("Reviews", "Отзывы");
        ru_content.put("Add to card", "Добавить в корзину");


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

        de_content.put("Quick view", "Kurz: ");
        de_content.put("More info", "mehr: ");
        de_content.put("Reviews", "Bewertungen: ");
        de_content.put("Add to card", "In den Warenkorb: ");

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


        en_content.put("Quick view", "Quick view");
        en_content.put("More info", "More info");
        en_content.put("Reviews", "Reviews");
        en_content.put("Add to card", "Add to card");

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



        String request_language = request.getParameter("lang");
        System.out.println(request_language);

        response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();

        if (request_language.equals("ru")){
            printWriter.println(ru_content);
        }
        else if (request_language.equals("en")){
            printWriter.println(en_content);

        }
        else if(request_language.equals("de")){
            printWriter.println(de_content);
        }



    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("123");


    }
}

package TestServlet.controller;

import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



@javax.servlet.annotation.WebServlet(name = "LangServlet")
public class LangServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JSONObject en_content = new JSONObject();
        JSONObject ru_content = new JSONObject();
        JSONObject de_content = new JSONObject();

        en_content.put("zdarova", "cheto na englishe");
        ru_content.put("zdarova", "����");
        de_content.put("zdarova", "preis");

//TODO rewrite;
        ru_content.put("Quick view", "������");
        ru_content.put("More info", "���������");
        ru_content.put("Reviews", "������");
        ru_content.put("add_to_card", "�������� � �������");

        ru_content.put("Artist", "�����������: ");
        ru_content.put("Album", "������: ");
        ru_content.put("Label", "�����: ");
        ru_content.put("Year", "��� ������������: ");
        ru_content.put("Country", "������: ");
        ru_content.put("Type", "���: ");
        ru_content.put("Format", "������: ");
        ru_content.put("Condition", "���������: ");
        ru_content.put("Genre", "����: ");
        ru_content.put("Available", "� �������: ");
        ru_content.put("Price", "���������:");

        ru_content.put("Quantity", "����������: ");
        ru_content.put("Current_price", "����: ");
        ru_content.put("Total_cost", "���� ������:");
        ru_content.put("Card_info", "��������� � �������");
        ru_content.put("Your_order", "��� �����:");

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

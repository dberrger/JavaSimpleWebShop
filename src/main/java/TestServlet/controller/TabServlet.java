package TestServlet.controller;

import TestServlet.service.ProductManager;
import org.json.simple.JSONObject;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TabServlet")
public class TabServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject tab = new JSONObject();

        if(getInitParameter("default_tab").equals("1")){
            tab.put("default_tab", "1");
        }
        else if (getInitParameter("default_tab").equals("2")) {
            tab.put("default_tab", "2");
        }
        else if(getInitParameter("default_tab").equals("3")){
            tab.put("default_tab", "3");
        }
        PrintWriter out = response.getWriter();
        out.println(tab);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestData = request.getParameter("productID");
        ProductManager productManager = new ProductManager();
        String album =productManager.getElementById(Integer.parseInt(requestData)).getAlbum();
        String albumCover = productManager.getElementById(Integer.parseInt(requestData)).getAlbum_cover();
        String artist = productManager.getElementById(Integer.parseInt(requestData)).getArtist();
        String country = productManager.getElementById(Integer.parseInt(requestData)).getCountry();
        String genre = productManager.getElementById(Integer.parseInt(requestData)).getGenre();
        String year = productManager.getElementById(Integer.parseInt(requestData)).getYear();
        int price = productManager.getElementById(Integer.parseInt(requestData)).getPrice();


        PrintWriter printWriter = response.getWriter();
        printWriter.println("<!DOCTYPE html>");
        printWriter.println("<html lang=\"en\">");
        printWriter.println("<head>");
        printWriter.println("<meta charset=\"UTF-8\">");
        printWriter.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"/shop_interface/product_cart/style.css\">");
        printWriter.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
        printWriter.println("<link rel=\"stylesheet\" href=\"/shop_interface/index_page/css/header-style.css\">");
        printWriter.println("<link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>");
        printWriter.println("<title>LP</title>");
        printWriter.println("</head>");
        printWriter.println("<body onload=\"init("+getInitParameter("default_tab")+")\">");
        printWriter.println("<header class=\"header-login-signup\">");
        printWriter.println("<div class=\"header-limiter\">");
        printWriter.println("<h1><a href=\"#\">Vinyl<span>shop</span></a></h1>");
        printWriter.println(" <nav>");
        printWriter.println("<a href=\"#\">Home</a>");
        printWriter.println("<a href=\"#\">RU</a>");
        printWriter.println("<a href=\"#\">EN</a>");
        printWriter.println("<a href=\"#\">DE</a>");
        printWriter.println("<a href=\"#\" >History <!-- for non registered user????--></a>");
        printWriter.println("<a href=\"#\"><img src=\"/shop_interface/shopping_cart.png\" width=\"15px\" alt=\"shopping_cart\">Card</a>");
        printWriter.println("</nav>");

        printWriter.println("<ul>");
        printWriter.println("<li><a href=\"#\">Login</a></li>");
        printWriter.println("<li><a href=\"#\">Sign up</a></li>");
        printWriter.println("</ul>");

        printWriter.println("</div>");

        printWriter.println("</header>");
        // printWriter.println("<form name=\"product\" method=\"post\" action="/">");
        printWriter.println("<div class=\"wrap\">");
        printWriter.println("<div class=\"product_header\">");
        printWriter.println("<h1>Product card</h1>");
        printWriter.println("</div>");
        printWriter.println("<div id=\"nav_list\">");
        printWriter.println("<ul>");
        printWriter.println("<li class=\"Quick view\" onclick=\"quickReview()\">Quick view</li>");
        printWriter.println("<li class=\"Reviews\" onclick=\"reviews()\">Reviews</li>");
        printWriter.println("<li class=\"More info\" onclick=\"moreInfo()\">More info</li>");
        printWriter.println("</ul>");
        printWriter.println("<div id=\"Language\">");
        printWriter.println("<a onclick=\"func('ru')\">RU</a>");
        printWriter.println("<a onclick=\"func('en')\">EN</a>");
        printWriter.println("<a onclick=\"func('de')\">DE</a>");
        printWriter.println("</div>");
        printWriter.println("</div>");
        printWriter.println(" <div id=\"info\"></div>");
        printWriter.println("<table id=\"shop\">");
        printWriter.println("<tbody>");
        printWriter.println("<td id=\"image_container\">");
        printWriter.println("<a class=\"image_box\" href=\"\">");
        printWriter.println("<img src=\"shop_interface/"+albumCover+".jpg\" width=\"320px\" alt=\"alt_name\">");
        printWriter.println("</a>");
        printWriter.println("</td>");
        printWriter.println("<td id=\"product_description\">");
        printWriter.println("<div id=\"description_container\">");
        printWriter.println("<div>");
        //  printWriter.println("<span class=\"\"> Blabladfl;'dskfl;'sdfsdf:</span>");
        printWriter.println("</div>");
        printWriter.println("<div>");
        printWriter.println("<span class=\"Artist\"> Artist:</span>");
        printWriter.println("<span class=\"Artist_param\">"+artist +"</span>");
        printWriter.println(" </div>");
        printWriter.println("<div>");
        printWriter.println("<span class=\"Album\"> Album:</span>");
        printWriter.println("<span class=\"Album_param\">"+album+"</span>");
        printWriter.println("</div>");
        printWriter.println("<div>");
        printWriter.println("<span class=\"Year\"> Year:</span>");
        printWriter.println("<span class=\"Year_param\">"+year+"</span>");
        printWriter.println("</div>");
        printWriter.println("<div>");
        printWriter.println("<span class=\"Country\"> Country:</span>");
        printWriter.println("<span class=\"Country_param\">"+country+"</span>");
        printWriter.println("</div>");
        printWriter.println("<div>");
        printWriter.println("<span class=\"Genre\"> Genre:</span>");
        printWriter.println("<span class=\"Genre_param\">"+genre+"</span>");
        printWriter.println("</div>");
        printWriter.println("<div>");
        printWriter.println("<span class=\"Price\"> Price:</span>");
        printWriter.println("<span class=\"Price_param\">"+price+"</span>");
        printWriter.println("</div>");
        printWriter.println("<div id=\"card_container\">");
        printWriter.println("<button class=\"add_to_card\" type=\"button\" >ADD TO CARD</button>");
        printWriter.println("</div>");
        printWriter.println("</div>");
        printWriter.println("</td>");
        printWriter.println("</tbody>");
        printWriter.println("</table>");

        printWriter.println("</div>");
        printWriter.println("</form>");
        printWriter.println("<script type=\"text/javascript\" src=\"shop_interface/product_cart/deftab.js\"></script>");
        printWriter.println("<script type=\"text/javascript\" src=\"shop_interface/product_cart/translateCard.js\"></script>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}

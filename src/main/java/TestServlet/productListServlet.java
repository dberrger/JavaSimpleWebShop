package TestServlet;

import org.json.simple.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

//TODO rename &
@WebServlet(name = "productListServlet")
public class productListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        ProductManager toFilter = new ProductManager();
        JSONObject jsonObject = new JSONObject();
        ArrayList<Product> products = new ArrayList<Product>();
        products = toFilter.FilterByPriceRange(request.getParameter("lowerBound"), request.getParameter("upperBound"));
        jsonObject = toFilter.currentFilterToJSON(products);
        System.out.println(toFilter.FilterByPriceRange(request.getParameter("lowerBound"), request.getParameter("upperBound")).get(0).getArtist().toString());
        /* Cookie firstName = new Cookie("first_name", toFilter.FilterByPriceRange(request.getParameter("lowerBound"),request.getParameter("upperBound")).get(1).toString());
        Cookie lastName = new Cookie("last_name", "chlen");
        response.addCookie(lastName);
        */
        Cookie c = new Cookie("FILTER" , "hui");
        c.setMaxAge(24*60*60);
        response.addCookie(c);
        RequestDispatcher rd = request.getRequestDispatcher("/shop_interface/index_page/productList.jsp");
        rd.forward(request,response);
        out.println("Hello");

    }
}

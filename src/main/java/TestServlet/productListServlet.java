package TestServlet;

import org.json.simple.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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

      // System.out.println(toFilter.currentFilterToJSON(toFilter.Filter(request.getParameter("lowerBound"))));
         out.println(toFilter.currentFilterToJSON(toFilter.FilterByPriceRange(request.getParameter("lowerBound"),request.getParameter("upperBound"))));



    }
}

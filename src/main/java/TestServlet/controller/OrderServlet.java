package TestServlet.controller;

import TestServlet.service.ItemQuantityPrice;
import TestServlet.service.OrderManager;
import TestServlet.service.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "OrderServlet", urlPatterns = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        System.out.println(request.getParameter("customer_name"));
        System.out.println(request.getParameter("customer_address"));
        HttpSession session = request.getSession();
        ArrayList<ItemQuantityPrice> listOfItemQuantityPriceToAdd = (ArrayList<ItemQuantityPrice>)session.getAttribute("listOfItemQuantityPrice");
        ArrayList<Product> listOfProducts = (ArrayList<Product>)session.getAttribute("listOfProducts");
        ArrayList<Integer> listOfQuantities = (ArrayList<Integer>)session.getAttribute("listOfQuantities");
        ArrayList<Integer> listOfPrices = (ArrayList<Integer>)session.getAttribute("listOfPrices");

        OrderManager orderManager = new OrderManager();
        orderManager.addOrder(request.getParameter("customer_name"),request.getParameter("customer_address"),listOfItemQuantityPriceToAdd);

        printWriter.println("OK!");
        listOfItemQuantityPriceToAdd.clear();
        listOfProducts.clear();
        listOfPrices.clear();
        listOfQuantities.clear();

        session.removeAttribute("sumOfCard");
        session.removeAttribute("productCount");
        session.removeAttribute("listOfItemQuantityPrice");
        session.removeAttribute("listOfProducts");
        session.removeAttribute("listOfQuantities");
        session.removeAttribute("listOfPrices");
        //TODO session.removeAtr('')
        //Clear all lists.
        //----------------------

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

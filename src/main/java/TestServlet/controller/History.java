package TestServlet.controller;

import TestServlet.dao.Customers;
import TestServlet.service.ItemQuantityPrice;
import TestServlet.service.OrderBean;
import TestServlet.service.OrderManager;
import TestServlet.service.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "History", urlPatterns = "/History")
public class History extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customers customers = new Customers();


        OrderManager orderManager = new OrderManager();
        ArrayList<ItemQuantityPrice> history = orderManager.getOrders(2);
        //************************************************************************************
        ArrayList<Product> products = new ArrayList<Product>();
        ArrayList<Integer> quantities = new ArrayList<Integer>();
        ArrayList<String> dateTimes = new ArrayList<String>();
        for (int i = 0; i < history.size(); i++) {
            products.add(history.get(i).getProduct());
            quantities.add(history.get(i).getQuantity());
            dateTimes.add(history.get(i).getDateTime());
        }
        session.setAttribute("listOfProductsHistory", products);
        session.setAttribute("listOfQuantitiesHistory", quantities);
        session.setAttribute("dateTimesHistory", dateTimes);
        System.out.println(products);
        System.out.println(quantities);
        System.out.println(dateTimes);

    }
}

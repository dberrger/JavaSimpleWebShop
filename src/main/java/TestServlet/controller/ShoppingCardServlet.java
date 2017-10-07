package TestServlet.controller;

import TestServlet.dao.ItemQuantityPrice;
import TestServlet.dao.Order;
import TestServlet.dao.Product;
import TestServlet.service.OrderBean;
import TestServlet.service.ProductManager;

import javax.ejb.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.ArrayList;

@WebServlet(name = "ShoppingCardServlet", urlPatterns = "/ShoppingCardServlet")
public class ShoppingCardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestData = request.getParameter("productID");
        HttpSession session = request.getSession();
        //session.setMaxInactiveInterval(5);
        System.out.println(requestData);
        if (session.getAttribute("productToOrder") == null) {
            System.out.println("Herer!");
            OrderBean productToOrder = new OrderBean();
            ArrayList<ItemQuantityPrice> listOfItemQuantityPrice =  productToOrder.addListOfItemQuantityPrice(Integer.parseInt(requestData));
            ArrayList<Product> listofProducts = new ArrayList<Product>();
            ArrayList<Integer> listofQuantities = new ArrayList<Integer>();
            ArrayList<Integer> listofPrices = new ArrayList<Integer>();
            int sumOfCard = productToOrder.sumOfCard(listOfItemQuantityPrice);
            session.setAttribute("productToOrder", productToOrder);

            for(int i=0;i<listOfItemQuantityPrice.size();i++){
                listofProducts.add(listOfItemQuantityPrice.get(i).getProduct());
                listofQuantities.add(listOfItemQuantityPrice.get(i).getQuantity());
                listofPrices.add(listOfItemQuantityPrice.get(i).getPrice());
            }

            session.setAttribute("listOfPrices", listofPrices);
            session.setAttribute("listOfProducts", listofProducts);
            session.setAttribute("listOfQuantities", listofQuantities);
            session.setAttribute("sumOfCard", sumOfCard);

           /* session.setAttribute("productToOrder", productToOrder);
            ArrayList<Product> list = productToOrder.addProduct(Integer.parseInt(requestData));
            session.setAttribute("card", list);
            System.out.println("card size here" + ((OrderBean) session.getAttribute("productToOrder")).getListOfProducts().size());*/
            //------------------------


        } else if (session.getAttribute("productToOrder") != null) {
            System.out.println("There!");
            System.out.println("pio " + session.getAttribute("productToOrder"));

            OrderBean productToOrderOld = (OrderBean) session.getAttribute("productToOrder");
            ArrayList<ItemQuantityPrice> listOfItemQuantityPrice =  productToOrderOld.addListOfItemQuantityPrice(Integer.parseInt(requestData));
            ArrayList<Product> listofProducts = new ArrayList<Product>();
            ArrayList<Integer> listofQuantities = new ArrayList<Integer>();
            ArrayList<Integer> listofPrices = new ArrayList<Integer>();
            int sumOfCard = productToOrderOld.sumOfCard(listOfItemQuantityPrice);
            session.setAttribute("productToOrder", productToOrderOld);
            for(int i=0;i<listOfItemQuantityPrice.size();i++){
                listofProducts.add(listOfItemQuantityPrice.get(i).getProduct());
                listofQuantities.add(listOfItemQuantityPrice.get(i).getQuantity());
                listofPrices.add(listOfItemQuantityPrice.get(i).getPrice());
            }
            session.setAttribute("listOfPrices", listofPrices);
            session.setAttribute("listOfProducts", listofProducts);
            session.setAttribute("listOfQuantities", listofQuantities);
            session.setAttribute("sumOfCard", sumOfCard);
            System.out.println("card size there" + ((OrderBean) session.getAttribute("productToOrder")).getListOfProducts().size());

        }

    }
}

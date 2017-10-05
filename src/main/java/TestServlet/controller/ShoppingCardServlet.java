package TestServlet.controller;

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

@WebServlet(name = "ShoppingCardServlet",urlPatterns = "/ShoppingCardServlet")
public class ShoppingCardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestData = request.getParameter("productID");
        HttpSession session = request.getSession();
        //session.setMaxInactiveInterval(5);
        System.out.println(requestData);
        if(session.getAttribute("productToOrder") == null){
            System.out.println("Herer!");
            OrderBean productToOrder = new OrderBean();
            productToOrder.createOrder();
            session.setAttribute("productToOrder",productToOrder);
            ArrayList<Product> list = productToOrder.addProduct(Integer.parseInt(requestData));
            session.setAttribute("card",list);
            System.out.println("card size here"+((OrderBean) session.getAttribute("productToOrder")).getListOfProducts().size());

        }
        else if(session.getAttribute("productToOrder") != null){
            System.out.println("There!");
            System.out.println("pio "+ session.getAttribute("productToOrder"));
            OrderBean productToOrderOld = (OrderBean)session.getAttribute("productToOrder");

            session.setAttribute("card",productToOrderOld.addProduct(Integer.parseInt(requestData)));
            System.out.println("card size there"+((OrderBean) session.getAttribute("productToOrder")).getListOfProducts().size());
            System.out.println(request.getAttribute("Orbean"));

        }

    }
}

package TestServlet.service;

import TestServlet.dao.Order;
import TestServlet.dao.Product;

import java.io.Serializable;

public class OrderBean implements Serializable {
    private Order order;
    private OrdersManager ordersManager;
    private int quantity;

    public void createOrder() {
        if (order == null) {
            order = new Order();
        }
    }

    public void addProduct(Product product){

            order = new Order();

        System.out.println("Hello1");
      // ordersManager.addToOrder(product, order,1);
       // System.out.println("Hello2");
    }
}

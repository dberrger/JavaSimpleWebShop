package TestServlet.service;

import TestServlet.dao.Order;
import TestServlet.dao.Product;

import java.io.Serializable;

public class OrderBean implements Serializable {
    private Order order;
    private OrdersManager ordersManager;
    private int quantity;

    public OrderBean() {}

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrdersManager getOrdersManager() {
        return ordersManager;
    }

    public void setOrdersManager(OrdersManager ordersManager) {
        this.ordersManager = ordersManager;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

   /* public void createOrder() {
        if (order == null) {
            order = new Order();
        }
    }*/

    public void addProduct(){

        //order = new Order()
      // ordersManager.addToOrder(product, order,1);
       // System.out.println("Hello2");
    }
}

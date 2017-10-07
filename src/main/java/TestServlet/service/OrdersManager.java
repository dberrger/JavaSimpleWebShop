package TestServlet.service;

import TestServlet.dao.DataBase;
import TestServlet.dao.Order;
import TestServlet.dao.Product;
import TestServlet.dao.ProductInOrder;

import java.io.Serializable;
import java.lang.management.ThreadInfo;
import java.util.ArrayList;

public class OrdersManager implements Serializable {
    private Order order;
    public Order createOrder(){
         order = new Order();
        //добавить сохранение persist
        return  order;
    }

    public boolean addToOrder(int productID, Order order, int quantity){
        //существует ли вещь с таким ID?!
        ProductManager productManager = new ProductManager();
        Product product = productManager.getElementById(productID);
        if(productManager.getElementById(productID) == null){
            System.out.println("Product not exist!>");
            return false;
        }
        //существует ли в бд заказ с таким ID>!&?
        //later
        ProductInOrder productInOrder = new ProductInOrder();
        productInOrder.setOrder(order);
        productInOrder.setProduct(product);
        productInOrder.setQuantity(quantity);
        // сохраняем в БД персист
        return true;
    }

    public ArrayList<ProductInOrder> getProductsInOrder(){
        return order.getProductInOrders();
    }
}

package TestServlet.service;

import TestServlet.dao.Order;
import TestServlet.dao.Product;
import TestServlet.dao.ProductInOrder;

import java.io.Serializable;
import java.lang.management.ThreadInfo;

public class OrdersManager implements Serializable {
    public Order createOrder(){
        Order order = new Order();
        //добавить сохранение persist
        return  order;
    }

    public boolean addToOrder(Product product, Order order, int quantity){
        //существует ли вещь с таким ID?!
        //существует ли в бд заказ с таким ID>!&?
        ProductInOrder productInOrder = new ProductInOrder();
        productInOrder.setOrder(order);
        productInOrder.setProduct(product);
        productInOrder.setQuantity(quantity);
        // сохраняем в БД персист
        return true;
    }
}

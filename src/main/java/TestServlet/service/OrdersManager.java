package TestServlet.service;

import TestServlet.dao.DataBase;
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

    public boolean addToOrder(int productID, Order order, int quantity){
        //существует ли вещь с таким ID?!
        ProductManager productManager = new ProductManager();
        if(productManager.getElementById(productID) == null){
            return false;
        }
        //существует ли в бд заказ с таким ID>!&?
        ProductInOrder productInOrder = new ProductInOrder();
        productInOrder.setOrder(order);
        productInOrder.setProduct(productManager.getElementById(productID));
        productInOrder.setQuantity(quantity);
        // сохраняем в БД персист
        return true;
    }
}

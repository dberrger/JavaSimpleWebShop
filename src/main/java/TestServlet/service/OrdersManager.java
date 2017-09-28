package TestServlet.service;

import TestServlet.dao.Order;
import TestServlet.dao.Product;
import TestServlet.dao.ProductInOrder;

import java.io.Serializable;
import java.lang.management.ThreadInfo;

public class OrdersManager implements Serializable {
    public Order createOrder(){
        Order order = new Order();
        //�������� ���������� persist
        return  order;
    }

    public boolean addToOrder(Product product, Order order, int quantity){
        //���������� �� ���� � ����� ID?!
        //���������� �� � �� ����� � ����� ID>!&?
        ProductInOrder productInOrder = new ProductInOrder();
        productInOrder.setOrder(order);
        productInOrder.setProduct(product);
        productInOrder.setQuantity(quantity);
        // ��������� � �� �������
        return true;
    }
}

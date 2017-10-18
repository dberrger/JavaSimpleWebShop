package TestServlet.service;

import TestServlet.dao.Customers;
import TestServlet.dao.OrderDAO;
import TestServlet.dao.OrderEntity;

import javax.servlet.http.HttpServlet;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.*;

public class OrderManager{

    public void addOrder(String customer_name, String customer_address, ArrayList<ItemQuantityPrice> list) {
        OrderEntity orderEntity = new OrderEntity();
        String orderID = UUID.randomUUID().toString();
        for (int i = 0; i < list.size(); i++) {
            Date date = new Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(date);
            orderEntity.setIDCustomer(2);
            orderEntity.setOrderID(orderID);
            orderEntity.setAddressCustomer(customer_address);
            orderEntity.setCustomerName(customer_name);
            orderEntity.setQuantityOfOrderedProduct(list.get(i).getQuantity());
            orderEntity.setProductID(list.get(i).getProduct().getId());
            orderEntity.setDateTimeOfOrder(currentTime);
            try {
                OrderDAO.addData(orderEntity);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<ItemQuantityPrice> getOrders(int customerID){

        List<OrderEntity> items = (List<OrderEntity>)OrderDAO.getCustomerOrdersByID(customerID);
        ArrayList<ItemQuantityPrice> list = new ArrayList<ItemQuantityPrice>();
        System.out.println(items);
        ProductManager productManager = new ProductManager();
        for (OrderEntity item : items) {
            ItemQuantityPrice itemQuantityPrice = new ItemQuantityPrice();
            itemQuantityPrice.setProduct(productManager.getElementById(item.getProductID()));
            itemQuantityPrice.setQuantity(item.getQuantityOfOrderedProduct());
            itemQuantityPrice.setDateTime(item.getDateTimeOfOrder());
            list.add(itemQuantityPrice);
        }
        return list;
    }
}

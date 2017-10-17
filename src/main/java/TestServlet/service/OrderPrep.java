package TestServlet.service;

import TestServlet.dao.ItemQuantityPrice;
import TestServlet.dao.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class OrderPrep {
    public void addOrder(String customer_name, String customer_address, ArrayList<ItemQuantityPrice> list) {
        Order order = new Order();
        String orderID = UUID.randomUUID().toString();
        for (int i = 0; i < list.size(); i++) {
            Date date = new Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(date);
            order.setIDCustomer(1);
            order.setOrderID(orderID);
            order.setAddressCustomer(customer_address);
            order.setQuantityOfOrderedProduct(list.get(i).getQuantity());
            order.setProductID(list.get(i).getProduct().getId());
            order.setDateTimeOfOrder(currentTime);
            try {
                order.addData(order);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

package TestServlet.service;

import TestServlet.dao.Customers;
import TestServlet.dao.OrderDAO;
import TestServlet.dao.OrderEntity;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.*;

public class OrderManager implements Serializable{
    final static Logger logger = Logger.getLogger(OrderManager.class);
    public void addOrder(String userID,String customer_name, String customer_address, ArrayList<ItemQuantityPrice> list) {
        logger.info("adding customers Order to SQL DB");
        OrderEntity orderEntity = new OrderEntity();
        Customers customers = new Customers();
        String orderID = UUID.randomUUID().toString();
        for (int i = 0; i < list.size(); i++) {
            Date date = new Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(date);
            orderEntity.setIDCustomer(customers.getMap().get(userID));
            orderEntity.setOrderID(orderID);
            orderEntity.setAddressCustomer(customer_address);
            orderEntity.setCustomerName(customer_name);
            orderEntity.setQuantityOfOrderedProduct(list.get(i).getQuantity());
            orderEntity.setProductID(list.get(i).getProduct().getId());
            orderEntity.setDateTimeOfOrder(currentTime);
            try {
                logger.info("Sending OrderEntity to DAO layer");
                OrderDAO.addData(orderEntity);
                logger.info("Order was added to DB!");
            } catch (SQLException e) {
                logger.error("EXEPTION!");
                e.printStackTrace();
            }
        }
    }

    public ArrayList<ItemQuantityPrice> getOrders(int customerID){
        logger.info("Gettin all orders from DB");
        List<OrderEntity> items = (List<OrderEntity>)OrderDAO.getCustomerOrdersByID(customerID);
        logger.info("Gettin all orders from DB -> Success!");
        ArrayList<ItemQuantityPrice> list = new ArrayList<ItemQuantityPrice>();
        ProductManager productManager = new ProductManager();
        for (OrderEntity item : items) {

            ItemQuantityPrice itemQuantityPrice = new ItemQuantityPrice();
            itemQuantityPrice.setProduct(productManager.getElementById(item.getProductID()));
            itemQuantityPrice.setQuantity(item.getQuantityOfOrderedProduct());
            itemQuantityPrice.setDateTime(item.getDateTimeOfOrder());
            list.add(itemQuantityPrice);
        }
        logger.info("list with  ItemQuantityDate ready to return to servlet");
        return list;
    }
}

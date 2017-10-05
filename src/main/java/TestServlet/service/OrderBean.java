package TestServlet.service;

import TestServlet.dao.DataBase;
import TestServlet.dao.Order;
import TestServlet.dao.Product;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderBean implements Serializable {
    private Order order;
    private OrdersManager ordersManager;
    private int quantity;
    private ArrayList<Product> listOfProducts =  new ArrayList<Product>();
    public OrderBean() {}

    public Order getOrder() {
        return order;
    }

    public OrderBean(ArrayList<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    public ArrayList<Product> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(ArrayList<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
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

    public void createOrder() {
        if (order == null) {
            order = new Order();
        }
    }

    public ArrayList<Product> addProduct(int productID){
       // ordersManager = new OrdersManager();
        //ordersManager.addToOrder(productID, order,1);
        System.out.println("HelloFrom OrderBEan addProduct.. productId is "+productID);
        ProductManager productManager = new ProductManager();
        DataBase db = new DataBase();
        listOfProducts.add(db.getProductsBase().get(productID));
        return listOfProducts;
    }
}

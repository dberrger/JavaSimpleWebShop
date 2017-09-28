package TestServlet.dao;

import java.util.ArrayList;

public class Order {
    //create ORDER
    //list of Products
    //+ quantity
    private int id;

    private ArrayList<ProductInOrder> productInOrders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<ProductInOrder> getProductInOrders() {
        return productInOrders;
    }

    public void setProductInOrders(ArrayList<ProductInOrder> productInOrders) {
        this.productInOrders = productInOrders;
    }
}

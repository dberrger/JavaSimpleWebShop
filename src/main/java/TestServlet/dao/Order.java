package TestServlet.dao;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToMany
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

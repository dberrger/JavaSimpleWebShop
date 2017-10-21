package TestServlet.dao;

import TestServlet.service.HibernateUtil;

import javax.swing.*;
import java.sql.SQLException;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "db",name = "test_db")
public class OrderEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "order_id")
    private String orderID;
    @Basic
    @Column(name ="product_id")
    private int productID;
    @Basic
    @Column(name = "customer_id")
    private int IDCustomer;
    @Basic
    @Column(name = "quantity")
    private int quantityOfOrderedProduct;
    @Basic
    @Column(name = "order_address")
    private String AddressCustomer;
    @Basic
    @Column(name = "order_date")
    private String DateTimeOfOrder;
    @Column(name = "customer_name")
    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getIDCustomer() {
        return IDCustomer;
    }

    public void setIDCustomer(int IDCustomer) {
        this.IDCustomer = IDCustomer;
    }

    public int getQuantityOfOrderedProduct() {
        return quantityOfOrderedProduct;
    }

    public void setQuantityOfOrderedProduct(int quantityOfOrderedProduct) {
        this.quantityOfOrderedProduct = quantityOfOrderedProduct;
    }

    public String getAddressCustomer() {
        return AddressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        AddressCustomer = addressCustomer;
    }

    public String getDateTimeOfOrder() {
        return DateTimeOfOrder;
    }

    public void setDateTimeOfOrder(String dateTimeOfOrder) {
        DateTimeOfOrder = dateTimeOfOrder;
    }


}


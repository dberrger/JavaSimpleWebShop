package TestServlet.dao;

import javax.swing.*;
import java.sql.SQLException;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(schema = "db",name = "test_db")
public class Order implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(name = "order_id")
    private int IDOfOrderedProduct;
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIDOfOrderedProduct() {
        return IDOfOrderedProduct;
    }

    public void setIDOfOrderedProduct(int IDOfOrderedProduct) {
        this.IDOfOrderedProduct = IDOfOrderedProduct;
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

    public void addData(Order order) throws SQLException {
       org.hibernate.Session session = null;
       try {
           session = HibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.save(order);
           session.getTransaction().commit();
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e.getMessage(), "������ ��� �������", JOptionPane.OK_OPTION);
       } finally {
           if (session != null && session.isOpen()) {

               session.close();
           }
       }
}}


package TestServlet.dao;

import TestServlet.service.HibernateUtil;
import TestServlet.service.ItemQuantityPrice;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrderDAO {
    public static void addData(OrderEntity orderEntity) throws SQLException {
        org.hibernate.Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(orderEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
    }
    public static Collection getCustomerOrdersByID(int customerID){

        Session session = null;
        List orders = new ArrayList<OrderEntity>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            orders = session.createCriteria(OrderEntity.class).list();
            Query query = session.createQuery("FROM OrderEntity as OE WHERE OE.IDCustomer = :customerID");
            query.setParameter("customerID", customerID);
            orders = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return orders;
    }
}

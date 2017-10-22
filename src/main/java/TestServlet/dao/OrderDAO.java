package TestServlet.dao;

import TestServlet.service.HibernateUtil;
import TestServlet.service.ItemQuantityPrice;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrderDAO {
    final static Logger logger = Logger.getLogger(OrderDAO.class);
    public static void addData(OrderEntity orderEntity) throws SQLException {
        logger.info("Adding OrderEntity to DB");
        org.hibernate.Session session = null;
        try {
            logger.info("Try to add OrderEntity to DB");
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(orderEntity);
            session.getTransaction().commit();
            logger.info("Try to add OrderEntity to DB _ > Success!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "������ ��� �������", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
    }
    public static Collection getCustomerOrdersByID(int customerID){
        logger.info("Try to get Customer orders by ID  from DB _ > Success!");
        Session session = null;
        List orders = new ArrayList<OrderEntity>();
        try {
            logger.info("Try to get Customer orders by ID  from DB");
            session = HibernateUtil.getSessionFactory().openSession();
            orders = session.createCriteria(OrderEntity.class).list();
            Query query = session.createQuery("FROM OrderEntity as OE WHERE OE.IDCustomer = :customerID");
            query.setParameter("customerID", customerID);
            orders = query.list();
            logger.info("Try to get Customer orders by ID  from DB _ > Success!");

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

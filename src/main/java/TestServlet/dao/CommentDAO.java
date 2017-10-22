package TestServlet.dao;

import TestServlet.service.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CommentDAO {
    public static void addComment(CommentEntity commentEntity) throws SQLException{
        org.hibernate.Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(commentEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static Collection getCommentsList(int customerID){
        Session session = null;
        List comments = new ArrayList<CommentEntity>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            comments = session.createCriteria(CommentEntity.class).list();
            Query query = session.createQuery("FROM CommentEntity as OE WHERE OE.IDCustomer = :customerID");
            query.setParameter("customerID", customerID);
            comments = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return comments;
    }
}

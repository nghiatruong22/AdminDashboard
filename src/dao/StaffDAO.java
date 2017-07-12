package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Staff;
import util.HibernateUtil;

/**
 *
 * @author NghiaTruongNgoc 
 */
public class StaffDAO {
    public static Staff getStaffInfor(String StaffId) {
        Staff Staff = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Staff = (Staff) session.get(Staff.class, StaffId);
        } catch (HibernateException ex) {             //Log the exception             
            System.err.println(ex);
        } finally {
            session.close();
        }
        return Staff;
    }
    
     public static List<Staff> getStaffList() {
        List<Staff> StaffList = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select st from Staff st";
            Query query = session.createQuery(hql);
            StaffList = (List<Staff>) query.list();

        } catch (HibernateException ex) {             //Log the exception             
            System.err.println(ex);
        } finally {
            session.close();
        }
        return StaffList;
    }

    public static boolean updateStaff(Staff Staff) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (getStaffInfor(Staff.getName()) == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            session.update(Staff);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception           
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
}

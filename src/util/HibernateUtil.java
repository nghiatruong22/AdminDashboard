/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author NghiaTruongNgoc
 */
import org.hibernate.cfg.Configuration; 
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.SessionFactory; 


@SuppressWarnings("deprecation")
public class HibernateUtil 
{
    private static final SessionFactory sessionFactory;     
    static 
    {           
        try 
        {            
            //sessionFactory = new Configuration().configure("pojo/hibernate.cfg.xml").buildSessionFactory();   
        	Configuration configuration = new Configuration();
            configuration.configure("pojo/hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                    configuration.getProperties()). buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } 
        catch (Throwable ex) 
        {              
            System.err.println("Initial SessionFactory creation failed." + ex);             
            throw new ExceptionInInitializerError(ex);         
        }     
    }     
    
    public static SessionFactory getSessionFactory() {         
        return sessionFactory;     
    } 
} 

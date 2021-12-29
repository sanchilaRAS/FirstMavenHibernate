package com.tute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project Started!" );
        //SessionFactory factory=new Configuration().configure().buildSessionFactory();
        
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        
        //Creating Student
        Student st=new Student();
        st.setId(106);
        st.setName("Sathsarani");
        st.setCity("Ratnapura");
        
        System.out.println(st);
        
        //Session session= factory.getCurrentSession();
        Session session= factory.openSession();
        
        Transaction tx= session.beginTransaction();
        session.save(st);
        //session.getTransaction().commit();
        tx.commit();

        session.close();
       
    }
}

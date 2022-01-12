package com.tute;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

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
    public static void main( String[] args ) throws IOException
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
        
        //Creating object of address class
        Address ad=new Address();
        ad.setStreet("street1");
        ad.setCity("Dhlhi");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(2335.98);
       
       //Reading image
        FileInputStream fis=new FileInputStream("src/main/java/download.png");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        Session session= factory.openSession();
        
        Transaction tx= session.beginTransaction();
        
        session.save(st);
        session.save(ad);
        
        tx.commit();

        session.close();
        System.out.println("Done");
       
    }
}

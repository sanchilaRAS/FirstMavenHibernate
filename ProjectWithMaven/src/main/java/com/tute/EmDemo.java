package com.tute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		Student student1=new Student();
		student1.setId(1);
		student1.setName("Amal");
		student1.setCity("Colombo");
		
		Student student2=new Student();
		student2.setId(2);
		student2.setName("Nimal");
		student2.setCity("Galle");
		
		Certificate certificate=new Certificate();
		certificate.setCourse("Python");
		certificate.setDuration("3 months");
		student1.setCerti(certificate);
		
		Certificate certificate1=new Certificate();
		certificate1.setCourse("Java");
		certificate1.setDuration("2 months");
		student2.setCerti(certificate1);
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		
		//object save
		s.save(student1);
		s.save(student2);
		
		tx.commit();
		factory.close();
	}

}

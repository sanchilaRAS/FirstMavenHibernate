package com.tute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		//get, load example.
		
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session session=factory.openSession();
		
		//load-student:106
		//load will give an exception if the value is not in table
		Student student=(Student)session.load(Student.class, 106);
		System.out.println(student+"\n");
		
		Address ad=(Address)session.get(Address.class, 1);
		System.out.println(ad.getStreet()+":"+ad.getCity());
		
		Address ad1=(Address)session.get(Address.class, 1);
		System.out.println(ad1.getStreet()+":"+ad1.getCity());
		
		
		
		session.close();
		factory.close();
	}
	
}

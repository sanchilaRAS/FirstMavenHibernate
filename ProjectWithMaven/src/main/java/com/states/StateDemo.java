package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tute.Certificate;
import com.tute.Student;

public class StateDemo {
	public static void main(String[] args) {
		//Practical of Hibernate Object State
		//Transient
		//Persistent
		//Detached
		//Removed
		System.out.println("Example : ");
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//Creating Student object
		Student student=new Student();
		student.setId(1414);
		student.setName("Peter");
		student.setCity("Colombo");
		student.setCerti(new Certificate("Java Hibernate Cource", "2 months"));
		//student:Transient- when create new object
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(student);
		//student:Persistent state- when associated with db
		student.setName("John");
		
		tx.commit();
		
		session.close();
		//student:Detached
		student.setName("Kareem");
		System.out.println(student);
		
		factory.close();
		
	}
}

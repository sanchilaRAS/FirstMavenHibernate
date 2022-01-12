package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		
		    Configuration cfg=new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        SessionFactory factory=cfg.buildSessionFactory();
	        
	        
	        //Creating Question
	       /* Question q1=new Question();
	        q1.setQuestionid(1212);
	        q1.setQuestion("What is java?");
	        
	        //Creating answer
	        Answer answer1=new Answer();
	        answer1.setAnswerId(343);
	        answer1.setAns("Java is a programming language.");
	        answer1.setQuestion(q1);
	        
	        Answer answer2=new Answer();
	        answer2.setAnswerId(333);
	        answer2.setAns("With the Help of java we can create softwaer");
	        answer2.setQuestion(q1);
	        
	        Answer answer3=new Answer();
	        answer3.setAnswerId(363);
	        answer3.setAns("Java has different types of frameworks");
	        answer3.setQuestion(q1);
	        
	        List<Answer> list=new ArrayList<Answer>();
	        list.add(answer1);
	        list.add(answer2);
	        list.add(answer3);
	        
	        q1.setAnswers(list); 
;	        */
	       
	        /*
	      //Creating Question
	        Question q2=new Question();
	        q2.setQuestionid(242);
	        q2.setQuestion("What is collection Framework?");
	        
	        //Creating answer
	        Answer answer2=new Answer();
	        answer2.setAnswerId(344);
	        answer2.setAns("API works with objects in java.");
	        
	        answer2.setQuestion(q2);
	        q2.setAnswer(answer2);
	        */
	        
	        //Session
	        Session s=factory.openSession();
	        Transaction tx=s.beginTransaction();
	        
	        //save
	       /* s.save(answer1);
	        s.save(answer2);
	        s.save(answer3);
	        s.save(q1);
	      */
	        
	       Question q=(Question)s.get(Question.class, 1212);
	        
	       System.out.println(q.getQuestionid());
	       System.out.println(q.getQuestion());
	       //Lazy
	       System.out.println(q.getAnswers().size());
	        
	        /*System.out.println(q.getQuestion());
	        
	        for (Answer a:q.getAnswers()) {
	        	
	        	 System.out.println(a.getAns());
	 	        
	        }*/
	        
	        
	        tx.commit();
	        
	        
	        //fetching
	      /*  Question newQ=(Question)s.get(Question.class, 1212);
	        System.out.println(newQ.getQuestion());
	        System.out.println(getAnswers().getAns());*/
	        
	        s.close();
	        factory.close();
	}

}

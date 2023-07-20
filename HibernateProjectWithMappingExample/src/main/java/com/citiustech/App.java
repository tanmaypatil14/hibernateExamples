package com.citiustech;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		// Creating Question object
		Question question1 = new Question();
		question1.setQuestion("What is java");

		Answer answer1 = new Answer();
		answer1.setAnswer("Java is a programming language");
		question1.setAnswer(answer1);

		// Creating another question object
		Question question2 = new Question();
		question2.setQuestion("What is java");

		Answer answer2 = new Answer();
		answer2.setAnswer("Java is a programming language");
		question2.setAnswer(answer2);

		Session session = factory.openSession();
		System.out.println("Program started......");
		System.out.println("is session open - " + session.isOpen());

		Transaction transaction = session.beginTransaction();

		session.save(question1);
		session.save(question2);

		transaction.commit();
		
		Question question = (Question) session.get(Question.class, 2L);
		System.out.println(question);
		
		session.close();
		factory.close();
		System.out.println("Done........");
		System.out.println("is session open - " + session.isOpen());
		System.out.println("is factory closed - " + factory.isClosed());

	}
}

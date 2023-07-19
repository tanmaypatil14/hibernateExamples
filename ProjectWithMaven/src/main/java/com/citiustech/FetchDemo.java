package com.citiustech;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		System.out.println("Program started......");
		System.out.println("is session open - " + session.isOpen());
		
		Student student = (Student) session.get(Student.class, 105);
		System.out.println(student);
		System.out.println("------------------------------------------------------------------");
		Address address = (Address) session.load(Address.class, 3);
		System.out.println(address);
		
		session.close();
		factory.close();
		System.out.println("Done........");
		System.out.println("is session open - " + session.isOpen());
		System.out.println("is factory closed - " + factory.isClosed());
		
	}

}

package com.citiustech;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmbeddableDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		System.out.println("Program started......");
		System.out.println("is session open - " + session.isOpen());
		
		Student student = new Student();
		student.setId(2134);
		student.setName("Tanmay Patil");
		student.setCity("Pune");
		
		Certificate certificate = new Certificate();
		certificate.setCourse("Spring Boot");
		certificate.setCourseDuration("2 Months");
		
		student.setCertificate(certificate);
		
		session.beginTransaction();
		
		session.save(student);
		session.getTransaction().commit();
		
		session.close();
		factory.close();
		System.out.println("Done........");
		System.out.println("is session open - " + session.isOpen());
		System.out.println("is factory closed - " + factory.isClosed());
	}
}

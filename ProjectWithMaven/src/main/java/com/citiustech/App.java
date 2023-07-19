package com.citiustech;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started...");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		System.out.println(factory);
		Session session = factory.openSession();

		// Creating student object
		Student student = new Student();
		student.setId(105);
		student.setName("Tanmay Patil");
		student.setCity("Pune");

		// Creating address object
		Address address = new Address();
		address.setCity("Chalisgaon");
		address.setStreet("Bhadgaon Road");
		address.setX(3256.323);
		address.setAddressAdded(new Date());

		// Reading image
		FileInputStream fileInputStream = new FileInputStream("src/main/java/logo.png");
		byte[] data = new byte[fileInputStream.available()];
		fileInputStream.read(data);

		address.setImage(data);

		session.beginTransaction();

		session.save(student);
		session.save(address);

		session.getTransaction().commit();
		
		fileInputStream.close();

		session.close();
		factory.close();
		System.out.println("done");
		System.out.println("is session open - " + session.isOpen());
		System.out.println("is factory closed - " + factory.isClosed());
	}
}

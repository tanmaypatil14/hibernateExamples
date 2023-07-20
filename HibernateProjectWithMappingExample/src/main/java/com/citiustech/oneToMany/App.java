package com.citiustech.oneToMany;

import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		

		
		Instructor instructor = new Instructor();
		instructor.setInstructorName("Tanmay Patil");
		instructor.setSummary("FullStack Developer");
		
		Course course1 = new Course();
		course1.setCourseName("Core Java for Beginners");
		course1.setDuration("9 Hr's");
		course1.setInstructor(instructor);
		
		Course course2 = new Course();
		course2.setCourseName("Angular for Beginners");
		course2.setDuration("8 Hr's");
		course2.setInstructor(instructor);
		
		Course course3 = new Course();
		course3.setCourseName("microservices for Beginners");
		course3.setDuration("10 Hr's");
		course3.setInstructor(instructor);
		
		Set<Course> courses = new LinkedHashSet<Course>();
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		
		instructor.setCourses(courses);
		
		Session session = sessionFactory.openSession();
		System.out.println("Program started......");
		System.out.println("is session open - " + session.isOpen());
		
		Transaction transaction = session.beginTransaction();
		
//		session.save(instructor);
//		session.save(course1);
//		session.save(course2);
//		session.save(course3);
		
		transaction.commit();
		
		Instructor i = session.get(Instructor.class, 1L);
		
		System.out.println(i.getInstructorName());
		System.out.println(i.getSummary());
//		Lazy
		System.out.println(i.getCourses().size());
//		Set<Course> cours = i.getCourses();
//		cours.forEach(c -> System.out.println(c));
		
		session.close();
		sessionFactory.close();
		System.out.println("Done........");
		System.out.println("is session open - " + session.isOpen());
		System.out.println("is factory closed - " + sessionFactory.isClosed());
		System.out.println("is transaction is active - " + transaction.isActive());
	
	}

}

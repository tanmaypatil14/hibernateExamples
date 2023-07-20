package com.citiustech.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Employee employee1 = new Employee();
		employee1.setEmployeeName("Tanmay Patil");
		
		Employee employee2 = new Employee();
		employee2.setEmployeeName("Girish Shinde");
		
		Employee employee3 = new Employee();
		employee3.setEmployeeName("Girish Shinde");
		
		Project project1 = new Project();
		project1.setProjectName("OPTUM");

		Project project2 = new Project();
		project2.setProjectName("HighMark");
		
		Project project3 = new Project();
		project3.setProjectName("DVTA");

		List<Employee> employees1 = new ArrayList<>();
		employees1.add(employee1);
		employees1.add(employee2);
		
		List<Employee> employees2 = new ArrayList<>();
		employees2.add(employee1);
		employees2.add(employee2);
		employees2.add(employee3);
		
		List<Project> projects1 = new ArrayList<>();
		projects1.add(project1);
		projects1.add(project2);
		
		List<Project> projects2 = new ArrayList<>();
		projects2.add(project1);
		projects2.add(project2);
		projects2.add(project3);
		
		employee1.setProjects(projects2);
		employee3.setProjects(projects1);
		
		project1.setEmployees(employees1);
		project3.setEmployees(employees2);
		
		
		Session session = sessionFactory.openSession();
		System.out.println("Program started......");
		System.out.println("is session open - " + session.isOpen());

		Transaction transaction = session.beginTransaction();		
		
		session.save(employee1);
		session.save(employee2);
		session.save(employee3);
		
		session.save(project1);
		session.save(project2);
		session.save(project3);

		transaction.commit();

		session.close();
		sessionFactory.close();
		System.out.println("Done........");
		System.out.println("is session open - " + session.isOpen());
		System.out.println("is factory closed - " + sessionFactory.isClosed());
		System.out.println("is transaction is active - " + transaction.isActive());

	}

}
 
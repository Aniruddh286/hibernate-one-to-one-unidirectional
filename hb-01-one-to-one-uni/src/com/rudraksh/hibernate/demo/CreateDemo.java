package com.rudraksh.hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rudraksh.hibernate.demo.entity.Instructor;
import com.rudraksh.hibernate.demo.entity.InstructorDetail;
import com.rudraksh.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create the objects
			/*Instructor tempInstructor = new Instructor("Ani", "Fataniya", "ani@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com/aniFataniya","Lean new things");*/
			
			Instructor tempInstructor = new Instructor("Rudra", "Fataniya", "rudu@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com/ruduFataniya","Tofan");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			
			//start a transaction
			session.beginTransaction();
			
			// save instructor
			// this will also save instructor detail object because of CascadeType.ALL
			session.save(tempInstructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}
		finally {
			factory.close();
		}

	}

}

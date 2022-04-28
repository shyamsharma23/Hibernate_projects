package myproject.hibernate.ProductDAOHiber.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentMain {
	public static void main(String[] args) {
		SessionFactory fact=new Configuration().configure("hiber.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Address.class).buildSessionFactory();
		Session ses=fact.openSession();
		Transaction tx=ses.beginTransaction();
		Address add=new Address();
		add.setAddressid(1001);
		add.setCity("Mumbai");
		add.setState("Maharashtra");
		Student s1=new Student();
		s1.setStudentid(1);
		s1.setStudentname("Anaita");
		s1.setScore(90);
		s1.setAdd(add);
		ses.save(s1);
		tx.commit();
		System.out.println("Data saved ");
		
	}

}

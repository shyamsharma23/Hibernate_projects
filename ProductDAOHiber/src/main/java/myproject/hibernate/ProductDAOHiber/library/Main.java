package myproject.hibernate.ProductDAOHiber.library;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {
	public static void main(String[] args) {
		SessionFactory fact=new Configuration().configure("hiber.cfg.xml").addAnnotatedClass(Librarian.class).addAnnotatedClass(Library.class).buildSessionFactory();
		Session ses=fact.openSession();
		Transaction tx=ses.beginTransaction();
		Librarian add=new Librarian();
		add.setCode(1001);
		add.setName("John");
		Library s1=new Library();
		s1.setLibrarycode(100);
		s1.setName("Parks");
		s1.setLib(add);
		ses.save(s1);
		tx.commit();
		System.out.println("Data saved ");
}
}

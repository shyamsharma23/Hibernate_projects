package myproject.hibernate.CartDAOHiber.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.*;

public class Main {
	
	private SessionFactory fact;//is an interface which contains pool of database connection
	private Session ses;
	
	public Main() {
		fact=new Configuration().configure("hiber.cfg.xml").
				addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class).buildSessionFactory();
	}
	
	public void insertDetails() {
		Session ses=fact.openSession();
		Transaction tx=ses.beginTransaction();
		Cart c = new Cart();
		c.setCart_id(2);
		c.setCart_name("mycart2");
		List<Product> plist = new ArrayList<>();
		Product p = new Product();
		p.setProduct_id(101);
		p.setProduct_name("Laptop");
		p.setPrice(10000);
		plist.add(p);
		Product p1 = new Product();
		p1.setProduct_id(102);
		p1.setProduct_name("Mouse");
		p1.setPrice(1000);
		plist.add(p1);
		c.setP_list(plist);
		ses.save(c);
		tx.commit();
		System.out.println("Data saved ");
		
		
	}
	
	public void delete(int id) {
		
		ses = fact.openSession();//Will retreive the object of Session
		Transaction tx=ses.beginTransaction();
		Product p = ses.find(Product.class, id);
		if(p!=null) {
			ses.delete(p);
			System.out.println("Product deleted");
		}
		else {
			System.out.println("Product does no exist");
		}
		tx.commit();
	}
	
	public static void main(String[] args) {
		
		Main main = new Main();
//		main.insertDetails();
		main.delete(101);
	}

}

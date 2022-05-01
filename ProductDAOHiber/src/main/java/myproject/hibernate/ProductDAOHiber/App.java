package myproject.hibernate.ProductDAOHiber;

/**
 * Hello world!
 *
 */
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App
{	
	private Scanner sc;
	private SessionFactory sessionfact;//is an interface which contains pool of database connection
	private Session ses;
	public App()
	{
		sessionfact=new Configuration().configure("hiber.cfg.xml").
				addAnnotatedClass(Product.class).buildSessionFactory();
	}
	public void insertData()
	{
		ses = sessionfact.openSession();//Will retreive the object of Session
		Transaction tx=ses.beginTransaction();
		Product p1 = new Product();
		p1.setProductid(2);
		p1.setProductname("Laptop");
		p1.setPrice(70000);
		ses.save(p1);
		tx.commit();
		System.out.println("Data Saved ");
	}
	public void getProductList()
	{
//		ses=sessionfact.openSession();
//		Query<Product> query=ses.createQuery("from Product");//it will retreive all the records from Product entity
//		List<Product> plist=query.list();
//		for(Product p:plist)
//		{
//			System.out.println("Product name is "+p.getProductname());
//		}
		System.out.println("Retreiving particular row from product");
		Query<Product> productdata=ses.createQuery("select p from Product p where p.productid=?1");
		System.out.println("Enter product id from which u want to retreive data");
		int pid=sc.nextInt();
		productdata.setParameter(1, pid);
		Product p1=productdata.getSingleResult();
		System.out.println("Product name retreived from database is "+p1.getProductname());
		
	
	}
	
		public void deleteData(int id)
		{
			ses=sessionfact.openSession();
			Transaction tx=ses.beginTransaction();
			Product s=ses.find(Product.class, id);
			if(s!=null)
			{
				ses.delete(s);
				System.out.println("Product deleted");
			}
			else
			{
				System.out.println("Product does not exist");
			}

		}
	
	
    public static void main( String[] args )
    {

	App a1=new App();
	//a1.insertData();
	a1.getProductList();
	}
}
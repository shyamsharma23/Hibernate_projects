package employee.hibernate.EmployeeDAOHiber;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;




/**
 * Hello world!
 *
 */
public class App 
{
	private SessionFactory sessionfact;//is an interface which contains pool of database connection
	private Session ses;

	
	public App()
	{
		sessionfact=new Configuration().configure("hiber.config.xml").
				addAnnotatedClass(Employee.class).buildSessionFactory();
		
	}
	public void insertData(int id, String name, double salary)
	{
		ses = sessionfact.openSession();//Will retreive the object of Session
		Transaction tx=ses.beginTransaction();
		Employee e1 = new Employee();
		e1.setEmpId(id);
		e1.setEmpName(name);
		e1.setSalary(salary);
		ses.save(e1);
		tx.commit();
		System.out.println("Data Saved ");
	}
	
	public void deleteData(int id) {
		
		ses=sessionfact.openSession();
		Transaction tx=ses.beginTransaction();
		Employee s=ses.find(Employee.class, id);
		if(s!=null)
		{
			ses.delete(s);
			System.out.println("Employee deleted");
		}
		else
		{
			System.out.println("Employee does not exist");
		}
		
	}
	
	public void updateData(double salary, String name, int id) {
		
		ses = sessionfact.openSession();//Will retreive the object of Session
		Transaction tx=ses.beginTransaction();
		Employee e1 = new Employee();
		e1.setEmpId(id);
		e1.setSalary(salary);
		e1.setEmpName(name);
		ses.saveOrUpdate(e1);
		tx.commit();
		
	}
	
	public void displayAll() {
		
		ses=sessionfact.openSession();
		Query<Employee> query=ses.createQuery("from Employee");//it will retreive all the records from Product entity
		List<Employee> plist=query.list();
		for(Employee p:plist)
		{
			System.out.println("Employee name is "+p.getEmpName());
		}
		
	}
    public static void main( String[] args )
    {
    	while(true) {
    		Scanner sc= new Scanner(System.in);
    		System.out.println("Enter the choice:");
    		System.out.println("Press 1 to insert the details");
    		System.out.println("Press 2 to delete the record");
    		System.out.println("Press 3 to update the record");
    		System.out.println("Press 4 to display the record");
    		System.out.println("Press 5 to exit");
    		
    		int c = sc.nextInt();
    		
    		if(c == 1) {
    			Scanner sc1 = new Scanner(System.in);
    			System.out.println("Enter the id of the employee");    			
    			int id = sc1.nextInt();
    			System.out.println("Enter the name of the employee");   
    			String name = sc1.next();
    			System.out.println("Enter the salary of the employee");
    			double salary = sc1.nextDouble();
    			App app = new App();
    			app.insertData(id, name, salary);
    			
    		}
    		if(c == 2) {
    			Scanner sc1 = new Scanner(System.in);
    			System.out.println("Enter the id you want to delete the record of");
    			int id = sc1.nextInt();
    			App app = new App();
    			app.deleteData(id);
    			
    		}
    		if(c == 3) {
    			Scanner sc1 = new Scanner(System.in);
    			
    			System.out.println("Enter the id of the employee you want to update:");
    			int id = sc1.nextInt();
    			
    			System.out.println("Enter the new name");
    			String name = sc1.next();
    			System.out.println("Enter the new salary");
    			double salary = sc1.nextDouble();
    			App app = new App();
    			app.updateData(salary, name, id);
    			
    		}
    		if(c == 4) {
    			
    			App app = new App();
    			app.displayAll();
    			
    			
    		}
    		else if(c == 5) {
    			break;
    			
    		}
    		
    		
    		
    	}
        
    	
    }
}

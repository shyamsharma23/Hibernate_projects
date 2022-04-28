package myproject.hibernate.ProductDAOHiber.onetomany;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {
	public static void main(String[] args) {
		SessionFactory fact=new Configuration().configure("hiber.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class).buildSessionFactory();
		Session ses=fact.openSession();
		Transaction tx=ses.beginTransaction();
		Department dep = new Department();
		List<Employee> list = new ArrayList<>();
		Employee emp = new Employee();
		emp.setEmp_id(100);
		emp.setName("John");
		emp.setSalary(10000);
		Employee emp1 = new Employee();
		emp1.setEmp_id(101);
		emp1.setName("Smith");
		emp1.setSalary(90000);
		list.add(emp);
		list.add(emp1);
		dep.setDepartment_code(200);
		dep.setDepartment_name("HR");
		dep.setEmplist(list);
		ses.save(dep);
		tx.commit();
		System.out.println("Data saved ");
		
	}
}
	

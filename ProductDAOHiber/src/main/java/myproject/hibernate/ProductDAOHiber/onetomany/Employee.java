package myproject.hibernate.ProductDAOHiber.onetomany;
import javax.persistence.*;

@Entity
@Table(name="Employee_table")
public class Employee {
	
	@Id
	private int emp_id;
	
	@Column
	private String name;
	
	private double salary;

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	

}

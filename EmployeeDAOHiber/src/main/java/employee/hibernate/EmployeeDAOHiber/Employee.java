package employee.hibernate.EmployeeDAOHiber;

import javax.persistence.*;

@Entity
@Table (name="EmployeeData")
public class Employee {
	
	@Id
	@Column (name = "Employee_id")
	private int empId;
	
	@Column (name = "Employee_name")
	private String empName;
	
	@Column (name = "Employee_salary")
	private double salary;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	

}

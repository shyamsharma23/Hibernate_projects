package myproject.hibernate.ProductDAOHiber.onetomany;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Department_table")
public class Department {
	
	@Id
	private int department_code;
	private String department_name;
	
	public int getDepartment_code() {
		return department_code;
	}

	public void setDepartment_code(int department_code) {
		this.department_code = department_code;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	@OneToMany(targetEntity=Employee.class,cascade = CascadeType.ALL)	
	@JoinColumn(name="department_id")
	private List<Employee> emplist;

	public List<Employee> getEmplist() {
		return emplist;
	}

	public void setEmplist(List<Employee> emplist) {
		this.emplist = emplist;
	}
	
	

}

package myproject.hibernate.ProductDAOHiber.onetoone;
import javax.persistence.*;

@Entity
@Table(name="Student_map")
public class Student {
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public Address getAdd() {
		return add;
	}
	public void setAdd(Address add) {
		this.add = add;
	}
	@Id
	private int studentid;
	@Column(name="StudentName")
	private String studentname;
	private int score;
	@OneToOne(targetEntity=Address.class,cascade = CascadeType.ALL)
	
	@JoinColumn(name="ADD_id",referencedColumnName="Address_id")
		
	private Address add;
	

}

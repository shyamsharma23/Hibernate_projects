package myproject.hibernate.ProductDAOHiber.library;
import javax.persistence.*;

@Entity
@Table (name="Librarian_table")
public class Librarian {
	
	@Id
	@Column (name="librarian_code")
	private int code;
	private String name;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

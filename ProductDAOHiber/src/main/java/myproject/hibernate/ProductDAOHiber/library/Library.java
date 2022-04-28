package myproject.hibernate.ProductDAOHiber.library;
import javax.persistence.*;


@Entity
@Table (name="Library")
public class Library {
	@Id
	@Column (name="library_code")
	private int librarycode;
	private String name;
	
	
	
	public Librarian getLib() {
		return lib;
	}
	public void setLib(Librarian lib) {
		this.lib = lib;
	}
	public int getLibrarycode() {
		return librarycode;
	}
	public void setLibrarycode(int librarycode) {
		this.librarycode = librarycode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToOne(targetEntity=Librarian.class,cascade = CascadeType.ALL)	
	@JoinColumn(name="Librarian_id",referencedColumnName="librarian_code")		
	private Librarian lib;
	

}

package myproject.hibernate.ProductDAOHiber.onetoone;
import javax.persistence.*;

@Entity
@Table(name="Address_map")
public class Address {
	@Id
	@Column(name="Address_id")
	private int addressid;
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	private String city;
	private String state;

	

}



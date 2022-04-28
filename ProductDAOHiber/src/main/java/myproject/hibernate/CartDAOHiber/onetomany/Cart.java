package myproject.hibernate.CartDAOHiber.onetomany;
import javax.persistence.*;

import myproject.hibernate.ProductDAOHiber.onetomany.Employee;

import java.util.*;

@Entity
@Table (name="Shopping_cart")
public class Cart {
	
	@Id
	private int cart_id;
	private String cart_name;
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public String getCart_name() {
		return cart_name;
	}
	public void setCart_name(String cart_name) {
		this.cart_name = cart_name;
	}
	
	@OneToMany(cascade = CascadeType.ALL)	
	@JoinColumn(name="Cart_id")
	private List<Product> p_list;
	public List<Product> getP_list() {
		return p_list;
	}
	public void setP_list(List<Product> p_list) {
		this.p_list = p_list;
	}

}

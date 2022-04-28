package myproject.hibernate.ProductDAOHiber;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="ProductData")
public class Product {
	@Id
	@Column(name="Product_id")
	private int productid;
	@Column(name="Product_name")
	private String productname;
	@Column(name="Product_price")
	private double price;
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}

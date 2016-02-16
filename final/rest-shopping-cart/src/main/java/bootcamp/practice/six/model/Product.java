package bootcamp.practice.six.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Yet another product class
 */
@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private double price;
	
	@ManyToOne
	private Category category;

	protected Product() {

	}

	public Product(String name, double price, Category category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
		this.category = new Category("Default", "default");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

}

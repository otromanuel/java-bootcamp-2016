package bootcamp.practice.six.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Represents an item in the cart. It has a product and the quantity of
 * instances of that product.
 */
@Entity
public class Item {

	@Id
	@GeneratedValue
	private Long id;

	@JsonIgnore
	@ManyToOne
	private Cart cart;
	@ManyToOne
	private Product product;
	private int quantity;
	
	Item() {
	}

	public Item(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Get the price to pay for this item.
	 * 
	 * @return Products price by quantity.
	 */
	public double getSubtotal() {
		return getProduct().getPrice() * getQuantity();
	}

}

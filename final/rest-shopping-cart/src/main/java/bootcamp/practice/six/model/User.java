package bootcamp.practice.six.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Represents a users account on the e-commerce store: it's commonly a customer.
 * 
 * Each user has its own shopping Cart.
 * 
 */
@Entity
public class User {

	@Id
	private String username;

	private String password;

	private Double credit;

	@OneToOne
	private Cart cart;

	public User() {
	}

	public User(String username, String password, Cart cart) {
		super();
		this.username = username;
		this.password = password;
		this.cart = cart;
		this.credit = 0D;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Double getCredit() {
		return credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

}

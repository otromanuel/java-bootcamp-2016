package bootcamp.practice.six.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * A concrete implementation of a shopping Cart.
 */
@Entity
public class Cart {

	@Id
	@GeneratedValue
	private long id;

	@OneToOne
	private User user;

	@OneToMany(mappedBy = "cart")
	private List<Item> items;

	/**
	 * The simplest constructor.
	 */
	public Cart() {
		this.items = new ArrayList<Item>();
	}

	/**
	 * Add an item to the cart.
	 */
	public void addItem(Item i) {
		if (!items.contains(i))
			items.add(i);
	}

	/**
	 * Remove item i from the cart.
	 * 
	 * @param i
	 */
	public void removeItem(Item i) {
		this.items.remove(i);
	}

	/**
	 * Get all the items to buy at the moment.
	 * 
	 * @return a list of all items on the cart.
	 */
	public List<Item> getItems() {
		return this.items;
	}

	/**
	 * How much for the cart?
	 * 
	 * @return Total amount of money to pay for the cart. A sum of all the items
	 *         in the cart.
	 */
	public double getTotal() {
		double subtotal = 0;
		for (Item item : getItems())
			subtotal = subtotal + item.getSubtotal();
		return subtotal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

package bootcamp.practice.three;

import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test cases for CartImplementation class.
 */
public class CartImplementationTest {

	private Cart cart;
	private Item mockItemA;
	private Item mockItemB;
	private Product productA;
	private Product productB;

	/**
	 * Set up the testing context.
	 */
	@Before
	public void setUp() {
		cart = new CartImplementation();
		productA = new Product("Cheese", 3.5);
		productB = new Product("Bread", 2.5);
		mockItemA = mock(Item.class);
		mockItemB = mock(Item.class);
		Mockito.when(mockItemA.getProduct()).thenReturn(productA);
		Mockito.when(mockItemB.getProduct()).thenReturn(productB);
	}

	/**
	 * When addItem() Then item is in cart.<br>
	 * When addItem() Then item has no duplicated item <br>
	 */
	@Test
	public void testAddItem() {
		cart.addItem(mockItemA);

		List<Item> items = cart.getItems();
		for (Item item : items)
			if (item.getProduct().getName().equals(mockItemA.getProduct().getName()))
				Assert.assertEquals(mockItemA, item);

		cart.addItem(mockItemA);
		cart.removeItem(mockItemA);
		for (Item item : items)
			Assert.assertNotEquals(mockItemA, item);
	}

	/**
	 * When removeItem() Then item is not in cart anymore.
	 */
	@Test
	public void testRemoveItem() {
		cart.addItem(mockItemA);
		cart.removeItem(mockItemA);
		List<Item> items = cart.getItems();
		for (Item item : items)
			Assert.assertNotEquals(mockItemA, item);
	}

	/**
	 * When getItems() Then return all items present in cart.
	 */
	@Test
	public void testGetItems() {
		cart.addItem(mockItemA);
		cart.addItem(mockItemB);
		
		Assert.assertTrue(cart.getItems().contains(mockItemA));
		Assert.assertTrue(cart.getItems().contains(mockItemB));
		
		cart.removeItem(mockItemA);
		cart.removeItem(mockItemB);
		
		Assert.assertTrue(cart.getItems().size() == 0);		
	}

	/**
	 * When getTotal() Then return the sum of all item subtotal.
	 */
	@Test
	public void testGetTotal() {
		Mockito.when(mockItemA.getSubtotal()).thenReturn(15.0);
		Mockito.when(mockItemB.getSubtotal()).thenReturn(10.0);

		cart.addItem(mockItemA);
		cart.addItem(mockItemB);
		Assert.assertEquals(25.0, cart.getTotal(), 0.00001);
	}

}

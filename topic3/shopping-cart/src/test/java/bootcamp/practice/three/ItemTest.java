package bootcamp.practice.three;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 * Test cases for the Item class.
 */
public class ItemTest {

	/**
	 * When getSubtotal() Then return quantity by product price
	 */
	@Test
	public void testGetSubtotal() {
		Product mockProduct = mock(Product.class);
		when(mockProduct.getPrice()).thenReturn(2.55);
		Item item = new Item(mockProduct,10);
		Assert.assertEquals(25.5, item.getSubtotal(), 0.001);
	}

}

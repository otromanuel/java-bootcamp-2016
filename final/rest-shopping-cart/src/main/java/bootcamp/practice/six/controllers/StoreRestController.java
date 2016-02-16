package bootcamp.practice.six.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.practice.six.model.Cart;
import bootcamp.practice.six.model.Item;
import bootcamp.practice.six.model.User;
import bootcamp.practice.six.repositories.CartRepository;
import bootcamp.practice.six.repositories.ItemRepository;
import bootcamp.practice.six.repositories.UserRepository;

/**
 * Main controller of the API.
 * Used to access main functionality of the e-commerce store.
 * 
 */
@RestController
@RequestMapping("/")
public class StoreRestController {

	private final CartRepository cartRepository;
	private final ItemRepository itemRepository;
	private final UserRepository userRepository;
	
	@Autowired
	StoreRestController(CartRepository cartRepository, ItemRepository itemRepository, UserRepository userRepository) {
		this.cartRepository = cartRepository;
		this.itemRepository = itemRepository;
		this.userRepository = userRepository;
	}
	
	@RequestMapping(path = "{username}/additem", method = RequestMethod.POST)
	public ResponseEntity<Void> addItem(@PathVariable String username, @RequestBody Item item) {
		this.itemRepository.save(item);
		Optional<Cart> cart = this.cartRepository.findByUserUsername(username);
		if ( cart.isPresent() ) {
			cart.get().addItem(item);
			cartRepository.save(cart.get());
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<>(HttpStatus.CONFLICT);
	}	
	
	@RequestMapping(path = "{username}/items", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> getItems(@PathVariable String username) {
		Optional<Cart> cart = this.cartRepository.findByUserUsername(username);
		if ( cart.isPresent() )
			return new ResponseEntity<List<Item>>(cart.get().getItems(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@RequestMapping(path = "{username}/checkout", method = RequestMethod.PUT)
	public ResponseEntity<Void> checkout(@PathVariable String username) {
		Optional<Cart> cart = this.cartRepository.findByUserUsername(username);
		if ( cart.isPresent() ) {
			User user = cart.get().getUser();
			if (user.getCredit() > cart.get().getTotal() ) {
				user.setCredit(user.getCredit() - cart.get().getTotal() );
				userRepository.save(user);
				return new ResponseEntity<>(HttpStatus.OK);
			}	
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
}

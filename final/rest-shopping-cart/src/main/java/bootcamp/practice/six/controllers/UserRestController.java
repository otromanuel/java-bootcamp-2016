package bootcamp.practice.six.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.practice.six.model.Cart;
import bootcamp.practice.six.model.User;
import bootcamp.practice.six.repositories.CartRepository;
import bootcamp.practice.six.repositories.UserRepository;

/**
 * Controller to access user related functionality.
 *
 */
@RestController
@RequestMapping("/user")
public class UserRestController {
	
	private UserRepository userRepository;
	private CartRepository cartRepository;
	
	
	@Autowired
	public UserRestController(UserRepository userRepository, CartRepository cartRepository) {
		this.userRepository = userRepository;
		this.cartRepository = cartRepository;		
	}
	
	@RequestMapping(path = "register", method = RequestMethod.POST)
	public ResponseEntity<User> register(@RequestParam String username, @RequestParam String password) {
		if  (!userRepository.findByUsername(username).isPresent()) {
			Cart cart = cartRepository.save(new Cart());
			// I know! Password should be encrypted.
			User user = userRepository.save(new User(username, password, cart));
			
			return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
		}
		else
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
	}
	
	@RequestMapping(path = "login", method = RequestMethod.POST)
	public ResponseEntity<User> login(@RequestParam String username, @RequestParam String password) {
		Optional<User> posibleUser = userRepository.findByUsername(username);
		if ( posibleUser.isPresent() ) 
			if ( posibleUser.get().getPassword().equals(password) )
				return new ResponseEntity<User>(posibleUser.get(), HttpStatus.OK);
		return new ResponseEntity<User>(HttpStatus.CONFLICT);	
	}
	
	@RequestMapping(path = "{username}/credit", method = RequestMethod.GET)
	public ResponseEntity<Double> credit(@PathVariable String username) {
		Optional<User> posibleUser = userRepository.findByUsername(username);
		if (!posibleUser.isPresent())
			return new ResponseEntity<Double>(HttpStatus.CONFLICT);
		else		
			return new ResponseEntity<Double>(posibleUser.get().getCredit(), HttpStatus.OK);		
	}
	
	@RequestMapping(path = "{username}/addcredit/{credit}", method = RequestMethod.GET)
	public ResponseEntity<Double> credit(@PathVariable String username, @PathVariable Double credit) {
		Optional<User> posibleUser = userRepository.findByUsername(username);
		if (!posibleUser.isPresent())
			return new ResponseEntity<Double>(HttpStatus.CONFLICT);
		else {
			posibleUser.get().setCredit(posibleUser.get().getCredit() + credit);
			userRepository.save(posibleUser.get());
			return new ResponseEntity<Double>(posibleUser.get().getCredit(), HttpStatus.OK);		
		}	
	}
	
	@RequestMapping(path = "{username}/cart", method = RequestMethod.GET)
	public ResponseEntity<Cart> getCart(@PathVariable String username) {
		Optional<User> posibleUser = userRepository.findByUsername(username);
		if (!posibleUser.isPresent())
			return new ResponseEntity<Cart>(HttpStatus.CONFLICT);
		else
			return new ResponseEntity<Cart>(posibleUser.get().getCart(), HttpStatus.OK);
	}
	

}

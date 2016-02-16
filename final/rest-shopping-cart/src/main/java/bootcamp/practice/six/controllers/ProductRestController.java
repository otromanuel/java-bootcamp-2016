package bootcamp.practice.six.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.practice.six.model.Product;
import bootcamp.practice.six.repositories.ProductRepository;

/**
 * This class lets exposes the REST API for product queries.
 *
 */
@RestController
@RequestMapping("/product")
public class ProductRestController {

	private final ProductRepository productRepository;

	@Autowired
	ProductRestController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@RequestMapping(path = "/name/{productName}", method = RequestMethod.GET)
	public Collection<Product> getProductByName(@PathVariable String productName) {
		return productRepository.findByNameContainsIgnoreCase(productName);
	}
	
	@RequestMapping(path = "/category/{categoryName}", method = RequestMethod.GET)
	public Collection<Product> getProductByCategory(@PathVariable String categoryName) {
		return productRepository.findByCategoryNameContainsIgnoreCase(categoryName);
	}

}

package bootcamp.practice.six.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.practice.six.model.Product;
import bootcamp.practice.six.repositories.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * This class lets exposes the REST API for product queries.
 *
 */
@RestController
@RequestMapping("/product")
@Api(value = "Product REST API", produces = "application/json")
public class ProductRestController {

	private final ProductRepository productRepository;

	@Autowired
	ProductRestController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@RequestMapping(path = "/name/{productName}", method = RequestMethod.GET)
	@ApiOperation(value = "Search by name", notes = "Search products by name. Case insensive, searches for partial and complete product names.")
	public Collection<Product> getProductByName(@PathVariable String productName) {
		return productRepository.findByNameContainsIgnoreCase(productName);
	}

	@RequestMapping(path = "/category/{categoryName}", method = RequestMethod.GET)
	@ApiOperation(value = "Search by category", notes = "Search products by its category name. Case insensive, searches for partial and complete product names.")
	public Collection<Product> getProductByCategory(@PathVariable String categoryName) {
		return productRepository.findByCategoryNameContainsIgnoreCase(categoryName);
	}

}

package bootcamp.practice.six;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import bootcamp.practice.six.controllers.ProductRestController;
import bootcamp.practice.six.controllers.StoreRestController;
import bootcamp.practice.six.model.Cart;
import bootcamp.practice.six.model.Category;
import bootcamp.practice.six.model.Item;
import bootcamp.practice.six.model.Product;
import bootcamp.practice.six.model.User;
import bootcamp.practice.six.repositories.CartRepository;
import bootcamp.practice.six.repositories.CategoryRepository;
import bootcamp.practice.six.repositories.ItemRepository;
import bootcamp.practice.six.repositories.ProductRepository;
import bootcamp.practice.six.repositories.UserRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Spring Boot Application loads the shoopping cart REST API.
 * 
 * It also loads some data to testing purpose. 
 *
 */
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackageClasses = { StoreRestController.class, ProductRestController.class })
public class RestShoppingCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestShoppingCartApplication.class, args);
	}

	@Bean
	CommandLineRunner init(CartRepository cartRepository, ItemRepository itemRepository, ProductRepository productRepository,
			CategoryRepository categoryRepository, UserRepository userRepository) {
		Cart cart = new Cart();
		cartRepository.save(cart);
		Category category = categoryRepository.save(new Category("Computers & Electronics", "electronics"));

		return (evt) -> Arrays.asList("laptop,pendrive,hard drive,monitor,mouse,keyboard".split(",")).forEach(a -> {
			User user = userRepository.save(new User("gandalf", "magic", cart));
			Product product = productRepository.save(new Product(a, 20, category));
			Item item = itemRepository.save(new Item(product, 1));
			cart.addItem(item);
			cart.setUser(user);
			cartRepository.save(cart);
		});
	}

}
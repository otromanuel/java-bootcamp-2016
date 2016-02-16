package bootcamp.practice.six.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import bootcamp.practice.six.model.Cart;

/**
 * http://localhost:8080/swagger-ui.html#/
 */
@RepositoryRestResource(collectionResourceRel = "cart", path = "cart")
public interface CartRepository extends JpaRepository<Cart, Long> {
	Optional<Cart> findById(Long id);

	Optional<Cart> findByUserUsername(String username);

}

package bootcamp.practice.six.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import bootcamp.practice.six.model.Product;

/**
 * JPA Repository to access Product entities.
 */
@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface ProductRepository extends JpaRepository<Product, Long> {

	Collection<Product> findByNameContainsIgnoreCase(String name);
	
	Collection<Product> findByCategoryNameContainsIgnoreCase(String categoryname);
	

}

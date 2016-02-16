package bootcamp.practice.six.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import bootcamp.practice.six.model.Item;

/**
 * JPA Repository to access Item entities.
 * 
 */
@RepositoryRestResource(collectionResourceRel = "item", path = "item")
public interface ItemRepository extends JpaRepository<Item, Long> {

	Collection<Item> findByProductName(String productName);

	Collection<Item> findByCartId(Long cartId);
}

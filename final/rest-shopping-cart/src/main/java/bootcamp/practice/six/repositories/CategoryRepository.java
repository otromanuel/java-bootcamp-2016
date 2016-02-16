package bootcamp.practice.six.repositories;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import bootcamp.practice.six.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	Optional<Category> findByName(String name);
	
	Collection<Category> findByNameContainsIgnoreCase(String name);

}

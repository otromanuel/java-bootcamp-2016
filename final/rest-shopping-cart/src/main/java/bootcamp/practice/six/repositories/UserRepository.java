package bootcamp.practice.six.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import bootcamp.practice.six.model.User;

/**
 * Interface to access User entities on the database. 
 *
 */
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends JpaRepository<User, String> {

	Optional<User> findByUsername(String username);

}

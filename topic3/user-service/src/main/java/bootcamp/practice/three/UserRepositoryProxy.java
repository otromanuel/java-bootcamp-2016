package bootcamp.practice.three;

import java.util.List;

/**
 * A proxy to access UserRepository in an abstract way.
 * Applies the proxy pattern.
 *
 */
public class UserRepositoryProxy implements UserRepositoryService {

	private UserRepositoryService userRepository;

	public UserRepositoryProxy(UserRepositoryService userRepository) {
		this.userRepository = userRepository;
	}

	public void saveUser(User user) {
		userRepository.saveUser(user);
	}

	public User getUserById(int userId) {
		return userRepository.getUserById(userId);
	}

	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}

	public boolean deleteUser(int userId) {
		return userRepository.deleteUser(userId);
	}

}

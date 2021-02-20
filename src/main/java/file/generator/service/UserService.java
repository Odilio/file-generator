package file.generator.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import file.generator.model.User;
import file.generator.repositorio.UserRepository;

@Service
public class UserService {
	
	 @Autowired
	 private UserRepository userRepository;

	   public User create(User user) {
		   return userRepository.save(user);
	   }

	public Optional<User> get(Long id) {
		return userRepository.findById(id);
	}
	
	public User getByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	 	
}
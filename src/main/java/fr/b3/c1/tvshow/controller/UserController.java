package fr.b3.c1.tvshow.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.b3.c1.tvshow.entity.User;
import fr.b3.c1.tvshow.exception.AlreadyExistsException;
import fr.b3.c1.tvshow.exception.NotFoundException;
import fr.b3.c1.tvshow.repository.UserJpaRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserJpaRepository userRepository;
	
	@GetMapping("/nickname/{nickname}")
	public User findByNickname(@PathVariable String nickname) {
		return userRepository.findByNickname(nickname);
	}
	
	@GetMapping
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping
	public User createUser(@RequestBody User user) throws AlreadyExistsException {
		if (user.getId() == null) {
			return userRepository.save(user);
		}
		
		throw new AlreadyExistsException();
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) throws NotFoundException {
		Optional<User> existingUser = userRepository.findById(id);
		if (existingUser.isPresent()) {
			user.setId(id);
			return userRepository.save(user);
		}
		
		throw new NotFoundException();
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable long id) throws NotFoundException {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
		} else {
			throw new NotFoundException();
		}
	}
}

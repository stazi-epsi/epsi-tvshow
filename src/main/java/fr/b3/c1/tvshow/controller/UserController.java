package fr.b3.c1.tvshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.b3.c1.tvshow.entity.User;
import fr.b3.c1.tvshow.service.UserService;

@RestController("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public User create(@RequestBody User user) {
		return userService.create(user);
	}
	
	@GetMapping("/{nickname}")
	public User findByNickname(@PathVariable String nickname) {
		return userService.findByNickname(nickname);
	}
}

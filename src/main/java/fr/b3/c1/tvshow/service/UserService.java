package fr.b3.c1.tvshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.b3.c1.tvshow.entity.User;
import fr.b3.c1.tvshow.repository.UserJpaRepository;

@Service
public class UserService {

	@Autowired
	private UserJpaRepository userJpaRepository;
	
	public User create(User user) {
		return userJpaRepository.save(user);
	}
	
	public User findByNickname(String nickname) {
		return userJpaRepository.findByNickname(nickname);
	}
}

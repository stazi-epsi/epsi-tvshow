package fr.b3.c1.tvshow.repository;

import java.util.List;

import fr.b3.c1.tvshow.entity.User;

public interface UserRepository {
	
	public List<User> search(String email, String nickname);
	public List<User> searchJpql(String email, String nickname);
}

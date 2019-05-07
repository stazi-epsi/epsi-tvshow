package fr.b3.c1.tvshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.b3.c1.tvshow.entity.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {
	
	public User findByNickname(String nickname);
}

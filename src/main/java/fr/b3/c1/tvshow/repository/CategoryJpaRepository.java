package fr.b3.c1.tvshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.b3.c1.tvshow.entity.Category;

@Repository
public interface CategoryJpaRepository extends JpaRepository<Category, Long> {
	
	public Category findByLabel(String label);
}

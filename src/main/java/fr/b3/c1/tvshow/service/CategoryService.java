package fr.b3.c1.tvshow.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.b3.c1.tvshow.entity.Category;
import fr.b3.c1.tvshow.repository.CategoryJpaRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryJpaRepository categoryJpaRepository;
	
	@Transactional
	public List<Category> findAll() {
		return categoryJpaRepository.findAll();
	}
}

package fr.b3.c1.tvshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.b3.c1.tvshow.entity.Category;
import fr.b3.c1.tvshow.repository.CategoryJpaRepository;

@RestController
@RequestMapping("/api/categories/")
public class CategoryController {

	@Autowired
	private CategoryJpaRepository categoryRepository;
	
	@GetMapping
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
}

package com.crud.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.crud.entity.Category;
import com.crud.repository.CategoryRepository;

import java.util.Optional;

@Service
public class CategoryService {

	

	    @Autowired
	    private CategoryRepository categoryRepository;

	    public Page<Category> getAllCategories(int page, int size) {
	        return categoryRepository.findAll(PageRequest.of(page, size));
	    }

	    public Optional<Category> getCategoryById(Long id) {
	        return categoryRepository.findById(id);
	    }

	    public Category createCategory(Category category) {
	        return categoryRepository.save(category);
	    }

	    public Category updateCategory(Long id, Category categoryDetails) {
	        Category category = categoryRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Category not found"));

	        category.setName(categoryDetails.getName());
	        return categoryRepository.save(category);
	    }

	    public void deleteCategory(Long id) {
	        Category category = categoryRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Category not found"));
	        categoryRepository.delete(category);
	    }
	}




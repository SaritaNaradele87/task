package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crud.entity.Category;
import com.crud.service.CategoryService;
@RestController
@RequestMapping("/api/categories")

public class CategoryController {

	
	

	    @Autowired
	    private CategoryService categoryService;

	    @GetMapping
	    public ResponseEntity<Page<Category>> getAllCategories(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {
	        Page<Category> categories = categoryService.getAllCategories(page, size);
	        return ResponseEntity.ok(categories);
	    }

	    // GET a category by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
	        return categoryService.getCategoryById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	    }

	    @PostMapping
	    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
	        Category createdCategory = categoryService.createCategory(category);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
	        Category updatedCategory = categoryService.updateCategory(id, categoryDetails);
	        return ResponseEntity.ok(updatedCategory);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
	        categoryService.deleteCategory(id);
	        return ResponseEntity.noContent().build();
	    }
	}




package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.exam.Category;
import com.exam.service.CategoryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	//adding category
	@PostMapping("/")
	public ResponseEntity<?> addCategory(@RequestBody Category category){ //question mark can be replaced here as we know we are going to return a category object
		Category addedCategory = this.categoryService.addCategory(category);
		return ResponseEntity.ok(addedCategory);
	}
	
	//getting single category
	@GetMapping("/{categoryId}")
	public Category getCategory(@PathVariable("categoryId") Long categoryId) {
		return this.categoryService.getCategory(categoryId);
	}
	
	//get all categories
	@GetMapping("/")
	public ResponseEntity<?> getCategories(){ //ResponseEntity<?> can be replaced by Set<Category> as we know what we are returning
		return ResponseEntity.ok(this.categoryService.getCategories());
	}
	
	//update category, will have to send id of entry being updated, else new entry will be added
	@PutMapping("/")
	public Category getCategory(@RequestBody Category category) {
		return this.categoryService.updateCategory(category);
	}
	
	//delete category
	@DeleteMapping("/{categoryId}")
	public boolean deleteCategory(@PathVariable("categoryId") Long categoryId) {
		return this.categoryService.deleteCategory(categoryId);
	}
}

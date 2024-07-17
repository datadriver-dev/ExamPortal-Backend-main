package com.exam.service;

import com.exam.model.exam.Category;
import java.util.*;

public interface CategoryService {
	
	public Category addCategory(Category category);
	
	public Category updateCategory(Category category);
	
	public Set<Category> getCategories();
	
	public Category getCategory(Long categoryId);
	
	public boolean deleteCategory(Long categoryId);
	
}

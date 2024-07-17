package com.exam.repo;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
	
	public HashSet<Quiz> findByCategory(Category category);
	
	public HashSet<Quiz> findByActive(Boolean active);
	
	//naming convention very important, wont work without required format
	public HashSet<Quiz> findByCategoryAndActive(Category category,Boolean active);
	
}

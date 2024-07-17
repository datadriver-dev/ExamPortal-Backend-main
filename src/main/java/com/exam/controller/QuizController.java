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
import com.exam.model.exam.Quiz;
import com.exam.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	//add quiz
	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}
	
	//update quiz, will have to send id of entry being updated, else new entry will be added
	@PutMapping("/")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz) {
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}
	
	//get all quiz
	@GetMapping("/")
	public ResponseEntity<?> getQuizzes() {
		return ResponseEntity.ok(this.quizService.getQuizzes());
	}
	
	//get all active quiz
	@GetMapping("/active")
	public ResponseEntity<?> getActiveQuizzes() {
		return ResponseEntity.ok(this.quizService.getActiveQuizzes());
	}
	
	//get quizzes in category
	@GetMapping("/category/{catId}")
	public ResponseEntity<?> getQuizzesInCategory(@PathVariable("catId") Long catId) {
		return ResponseEntity.ok(this.quizService.getQuizzesInCategory(catId));
	}
	
	//above category set in implementation function, below category set in controller function, check which to use
	
	//get active quizzes in category
	@GetMapping("/active/category/{catId}")
	public ResponseEntity<?> getActiveQuizzesInCategory(@PathVariable("catId") Long catId) {
		Category category = new Category();
		category.setcId(catId);
		return ResponseEntity.ok(this.quizService.getActiveQuizzesInCategory(category));
	}
	
	//get single quiz
	@GetMapping("/{quizId}")
	public ResponseEntity<?> getQuiz(@PathVariable("quizId") Long quizId) {
		return ResponseEntity.ok(this.quizService.getQuiz(quizId));
	}
	
	//delete quiz
	@DeleteMapping("/{quizId}")
	public boolean deleteQuiz(@PathVariable("quizId") Long quizId) {
		return this.quizService.deleteQuiz(quizId);
	}
	
}

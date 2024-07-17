package com.exam.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.repo.QuizRepository;
import com.exam.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		return new HashSet<>(this.quizRepository.findAll());
	}
	
	@Override
	public Set<Quiz> getQuizzesInCategory(Long catId) {
		Category category = new Category();
		category.setcId(catId);
		return new HashSet<>(this.quizRepository.findByCategory(category));
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		return this.quizRepository.findById(quizId).get();
	}

	@Override
	public boolean deleteQuiz(Long quizId) {
		this.quizRepository.deleteById(quizId);
		if(this.quizRepository.findById(quizId).isPresent()) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public Set<Quiz> getActiveQuizzes() {
		return new HashSet<>(this.quizRepository.findByActive(true));
	}

	@Override
	public Set<Quiz> getActiveQuizzesInCategory(Category cat) {
		return new HashSet<>(this.quizRepository.findByCategoryAndActive(cat, true));
	}

}

package com.exam.service;

import java.util.*;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;

public interface QuizService {
	
	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public Set<Quiz> getQuizzes();
	
	public Quiz getQuiz(Long quizId);
	
	public boolean deleteQuiz(Long quizId);

	public Set<Quiz> getQuizzesInCategory(Long catId);
	
	public Set<Quiz> getActiveQuizzes();
	
	public Set<Quiz> getActiveQuizzesInCategory(Category category);
	
}

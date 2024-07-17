package com.exam.controller;

import java.util.*;

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

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	//add question
	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
		
	//update question, will have to send id of entry being updated, else new entry will be added
	@PutMapping("/")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
		
	//get max specified questions of any quiz
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("quizId") Long quizId) {
//		Quiz quiz = new Quiz();
//		quiz.setqId(quizId);
//		return ResponseEntity.ok(this.questionService.getQuestionsOfQuiz(quiz));
		Quiz quiz = this.quizService.getQuiz(quizId);
		Set<Question> questions = quiz.getQuestions();
		List list = new ArrayList<>(questions);
		Collections.shuffle(list);
		if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions())) {
			list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions() + 1));
		}
		list.forEach(q -> ((Question) q).setAnswer("")); //not required can use json ignore
		return ResponseEntity.ok(list);
	}
		
	//get all questions of any quiz
		@GetMapping("/quiz/all/{quizId}")
		public ResponseEntity<?> getAllQuestionsOfQuiz(@PathVariable("quizId") Long quizId) {
			Quiz quiz = new Quiz();
			quiz.setqId(quizId);
			return ResponseEntity.ok(this.questionService.getQuestionsOfQuiz(quiz));
//			Quiz quiz = this.quizService.getQuiz(quizId);
//			Set<Question> questions = quiz.getQuestions();
//			List list = new ArrayList<>(questions);
//			Collections.shuffle(list);
//			if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions())) {
//				list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions() + 1));
//			}
//			return ResponseEntity.ok(list);
		}
		
	//get single question
	@GetMapping("/{quesId}")
	public ResponseEntity<?> getQuestion(@PathVariable("quesId") Long quesId) {
		return ResponseEntity.ok(this.questionService.getQuestion(quesId));
	}
	
	//delete quiz
	@DeleteMapping("/{quesId}")
	public boolean deleteQuestion(@PathVariable("quesId") Long quesId) {
		return this.questionService.deleteQuestion(quesId);
	}
	
	//evaluate result
	@PostMapping("/quiz/evaluate")
	public ResponseEntity<?> evaluateResult(@RequestBody List<Question> questions){
		//System.out.println(questions);
		double score=0.0;
		int correntAnswers=0;
		int attempts=0;
		double singleQuestionScore = Float.parseFloat(questions.get(0).getQuiz().getMaxMarks())/Float.parseFloat(questions.get(0).getQuiz().getNumberOfQuestions());
		for(Question q : questions){
			Question question = this.questionService.getQuestion(q.getQuesId());
			if(question.getAnswer().trim().equals(q.getAnswer().trim())) {
				score+=singleQuestionScore;
				correntAnswers++;
				attempts++;
			}
			else if(q.getAnswer().trim()==null || (q.getAnswer().trim().equals("")) ) {
				//attempts++;
			}
			else {
				attempts++;
			}
		}
		Map <Object, Object> resultMap = Map.of("score",score,"correctAnswers",correntAnswers,"attempts",attempts);
		return ResponseEntity.ok(resultMap);
	}
}

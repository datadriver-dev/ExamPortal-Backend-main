package com.exam.model.exam;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long qId;

	private String title;
	
	private String description;

	private String maxMarks;
	
	private String numberOfQuestions;
	
	private String totalTime;
	
	private boolean active = false;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	
	//quiz deletion requires 2 calls check fix - fixed make fetch type lazy in one to many in category
	@OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore //when we fetch quiz we wont get question data, we will have to fetch it separately
	private Set<Question> questions = new HashSet<>();

	public Quiz() {
	}

	/**
	 * @return the qId
	 */
	public Long getqId() {
		return qId;
	}

	/**
	 * @param qId the qId to set
	 */
	public void setqId(Long qId) {
		this.qId = qId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the maxMarks
	 */
	public String getMaxMarks() {
		return maxMarks;
	}

	/**
	 * @param maxMarks the maxMarks to set
	 */
	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}

	/**
	 * @return the numberOfQuestions
	 */
	public String getNumberOfQuestions() {
		return numberOfQuestions;
	}

	/**
	 * @param numberOfQuestions the numberOfQuestions to set
	 */
	public void setNumberOfQuestions(String numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return the questions
	 */
	public Set<Question> getQuestions() {
		return questions;
	}

	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	
	/**
	 * @return the totalTime
	 */
	public String getTotalTime() {
		return totalTime;
	}

	/**
	 * @param totalTime the totalTime to set
	 */
	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}

	
}

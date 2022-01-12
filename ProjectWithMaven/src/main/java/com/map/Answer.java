package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Answer {
	@Id
	@Column(name="answer_id")
	private int answerId;
	private String ans;
	
	//to ignore one map
	//@OneToOne(mappedBy = "answer")
	
	@ManyToOne
	private Question question;
	
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	
	
	public Answer(int answerId, String answer) {
		super();
		this.answerId = answerId;
		this.ans = answer;
	}
	public Answer() {
		super();
	}
}

package com.map;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question {
	
	@Id
	@Column(name="question_id")
	private int questionid;
	private String question;
	
	/*@OneToOne
	@JoinColumn(name="a_id")
	private Answer answer;*/
	
	@OneToMany(mappedBy = "question", fetch=FetchType.EAGER)
	private List<Answer> answers;
	
	public int getQuestionid() {
		return questionid;
	}
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	
	public Question(int questionid, String question, List<Answer> answers) {
		super();
		this.questionid = questionid;
		this.question = question;
		this.answers = answers;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
}

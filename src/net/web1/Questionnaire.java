package net.web1;

import java.util.Collection;

public class Questionnaire {

	public String theme;
	public String id;
	public Collection<Question> questions;
	
	public String getTheme(){
		return theme;
	}
	
	/* public Collection recupQuestion(){
		
	}*/
	
	public Questionnaire(String theme, String id, Collection questions) {
		super();
		this.theme = theme;
		this.id = id;
		this.questions = questions;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Collection getQuestions() {
		return questions;
	}

	public void setQuestions(Collection questions) {
		this.questions = questions;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Question next() {
		return questions.iterator().next();
	}
	
	
}

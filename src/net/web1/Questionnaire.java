package net.web1;

import java.util.Collection;
import java.util.Iterator;

public class Questionnaire {
    public Iterator<Question> qnext;
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
		this.qnext = questions.iterator();
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
		if(qnext.hasNext()){
		    return qnext.next();
		}else{
			this.qnext = questions.iterator();
		}
		return qnext.next();
	}
	
	
}

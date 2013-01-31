package net.web1;

import java.util.Collection;

public class Questionnaire {

	public String theme;
	public String id;
	public Collection questions;
	
	

	public Questionnaire(String theme, String id, Collection questions) {
		super();
		this.theme = theme;
		this.id = id;
		this.questions = questions;
	}
	
}

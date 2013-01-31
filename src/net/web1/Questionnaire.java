package net.web1;

import java.util.HashSet;

public class Questionnaire {

	public String theme;
	public String id;
	public HashSet questions;
	
	

	public Questionnaire(String theme, String id, HashSet questions) {
		super();
		this.theme = theme;
		this.id = id;
		this.questions = questions;
	}



	public static void main(String[] args) {
	}

	
	
}

package net.web1;


public class Question {

	public String titre;
	public String[] reponse;
	

	
	public Question(String titre, String[] question) {
		super();
		this.titre = titre;
		this.reponse = question;
		
	}



	public String getTitre() {
		return titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}



	public String getReponse(int i) {
		return reponse[i];
	}



	public void setReponse(String[] reponse) {
		this.reponse = reponse;
	}
	
	
}

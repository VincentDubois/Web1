package net.web1;

import java.util.Collections;
import java.util.Vector;

import android.widget.Button;


public class Question {

	public String titre;
	public String[] reponse;
	private Vector<Integer> correspondance;
	


	public Question(String titre, String[] question) {
		super();
		this.titre = titre;
		this.reponse = question;
		melange();
	}

	
	public void melange(){
		
		correspondance = new Vector<Integer>();
		correspondance.add(0);
		correspondance.add(1);
		correspondance.add(2);
		correspondance.add(3);	
		
		Collections.shuffle(correspondance);
	}
    
	public void eventreponse(){
	
	}

	public String getTitre() {
		return titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}



	public String getReponse(int i) {
		return reponse[correspondance.get(i)];
	}



	public void setReponse(String[] reponse) {
		this.reponse = reponse;
	}


	public boolean bonneReponse(int i) {
		return (correspondance.get(i) == 0);
	}
	
}

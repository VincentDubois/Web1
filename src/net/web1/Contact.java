package net.web1;

import android.graphics.Bitmap;

public class Contact {
	String id;
	String nom;
	Bitmap image;
	
	public Contact(String id, Bitmap image, String nom) {
		this.id = id;
		this.image = image;
		this.nom = nom;
	}
}




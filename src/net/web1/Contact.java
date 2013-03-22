package net.web1;

import android.graphics.Bitmap;
import android.os.Bundle;

public class Contact {
	String id;
	String nom;
	Bitmap image;
	
	public Contact(String id, Bitmap image, String nom) {
		this.id = id;
		this.image = image;
		this.nom = nom;
	}
	
	public Contact(Bundle bundle){
		this.id = bundle.getString("id");
		this.nom = bundle.getString("nom");
		this.image = bundle.getParcelable("image");
		
	}
	
	public Bundle bundle(){
		Bundle bundle = new Bundle();
		bundle.putString("id", id);
		bundle.putString("nom", nom);
		bundle.putParcelable("image", image);
		return bundle;
	}
	
}




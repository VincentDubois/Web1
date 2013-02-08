package net.web1;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;

import android.provider.ContactsContract;
import android.view.View;

import android.widget.Button;

public class MenuActivity extends Activity {

	private static final int PICK_CONTACT = 0;

	private ArrayList<Contact> liste;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

		liste = new ArrayList<Contact>();
		
		liste.add(new Contact(null, "Toto"));


		Button jeuLocal = (Button)findViewById(R.id.jeu_local);
		jeuLocal.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent t = new Intent(MenuActivity.this, Web1Activity.class);
				startActivity(t);
			}
		});





		Button rechercher_joueur = (Button) findViewById(R.id.rechercher_joueur);
		rechercher_joueur.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
				startActivityForResult(intent, PICK_CONTACT);
			}
		});
	}
}


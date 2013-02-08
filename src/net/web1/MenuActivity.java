package net.web1;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MenuActivity extends Activity {

	private static final int PICK_CONTACT = 0;

	private ArrayList<Contact> liste;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

		liste = new ArrayList<Contact>();
		
		liste.add(new Contact(null, "Toto"));
		liste.add(new Contact(null, "Titi"));
		liste.add(new Contact(null, "Tata"));


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
		
		ListView liste_joueurs;
		
		liste_joueurs = (ListView)findViewById(R.id.liste_joueurs);
		liste_joueurs.setAdapter(new ArrayAdapter<Contact>(
				getBaseContext(),
				R.layout.listcontact,
				R.id.contact_avatar,
				liste){
					@Override
					public View getView(int position, View convertView,
							ViewGroup parent) {
						if (convertView == null) 
						    convertView = getLayoutInflater().inflate(R.layout.listcontact,parent,false);
						((ImageView)convertView.findViewById(R.id.contact_avatar)).setImageBitmap(
								liste.get(position).image);
						((TextView)convertView.findViewById(R.id.contact_nom)).setText(
								liste.get(position).nom);
						return convertView;
					}
			
		} );
	}
}


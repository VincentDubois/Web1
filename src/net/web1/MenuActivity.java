package net.web1;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
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

	private ArrayAdapter<Contact> arrayAdapter;
	
	public boolean contact_present(String id){
		for (Contact contact : liste){
			
			if(id.equals(contact.id)){
			return false;	
			}
		}
		return true;
	}
	
	public Bitmap getPhoto(String id){
		Uri contactUri = ContentUris.withAppendedId(Contacts.CONTENT_URI, Long.parseLong(id));
		return BitmapFactory.decodeStream(Contacts.openContactPhotoInputStream(getContentResolver(), contactUri));
	}
	
	@Override
	public void onActivityResult(int reqCode, int resultCode, Intent data) {
		super.onActivityResult(reqCode, resultCode, data);
		if (reqCode == PICK_CONTACT){
			if (resultCode == Activity.RESULT_OK) {
				Uri contactData = data.getData();
				Cursor c =  managedQuery(contactData, null, null, null, null);
				if (c.moveToFirst()) {
					String id =c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts._ID));
					String nom = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
					Bitmap image = getPhoto(id);
					if(contact_present(id)){
						liste.add(new Contact(id, image, nom));
						arrayAdapter.notifyDataSetChanged();
					}
				}
			}
		}
	}
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);



		liste = new ArrayList<Contact>();

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
		arrayAdapter = new ArrayAdapter<Contact>(
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

		};
		liste_joueurs.setAdapter(arrayAdapter );
	
	}
}


package net.web1;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity {

	private static final int PICK_CONTACT = 0;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

		
		 Button rechercher_joueur = (Button) findViewById(R.id.rechercher_joueur);
	        rechercher_joueur.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
	            	startActivityForResult(intent, PICK_CONTACT);
	            }
	        });
}
}
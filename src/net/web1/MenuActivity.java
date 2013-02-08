package net.web1;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;

public class MenuActivity extends Activity {

	private ArrayList<Contact> liste;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
		liste = new ArrayList<Contact>();
		
}
}


package net.web1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);



		Button jeuLocal = (Button)findViewById(R.id.jeu_local);
		jeuLocal.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent t = new Intent(MenuActivity.this, Web1Activity.class);
				startActivity(t);
			}
		});

	}
}

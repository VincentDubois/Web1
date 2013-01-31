package net.web1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Web1Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ((TextView)findViewById(R.id.theme)).setText("Animaux");
        ((TextView)findViewById(R.id.question)).setText("Combien de bec à un canard auquel on a ajouté un bec en plastique pour déconner ?");
        ((Button)findViewById(R.id.button_R1)).setText("2");
        ((Button)findViewById(R.id.button_R2)).setText("1");
        ((Button)findViewById(R.id.button_R3)).setText("3");
        ((Button)findViewById(R.id.button_R4)).setText("9");
    }
    
   /* public boolean verification() {
    	if (currentTxt==t[0]){
    		return true;
    	}else{
    		return false;
    	}
	}*/
}
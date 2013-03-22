package net.web1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Web1Activity extends Activity {
	private Questionnaire questionnaire;
	private Question question;
	private AlarmReceiver rec;
	private ArrayList<Parcelable> listeContact;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Intent intent2 = this.getIntent();
		
		listeContact = intent2.getParcelableArrayListExtra("listeContact");
		ArrayList<Contact> liste = new ArrayList<Contact>();
		for(Parcelable bundle : listeContact ){
			liste.add(new Contact((Bundle) bundle));
		}
		lecture_xml();
		
		 // get a Calendar object with current time
		 Calendar cal = Calendar.getInstance();
		 // add 5 minutes to the calendar object
		 
	//	 cal.add(Calendar.MINUTE, 1);
		 cal.add(Calendar.SECOND, 15);
		 rec = new AlarmReceiver();
		 
		 Intent intent = new Intent(this, AlarmReceiver.class);
		 intent.putExtra("alarm_message", "perdu!");
		 // In reality, you would want to have a static variable for the request code instead of 192837
		 PendingIntent sender = PendingIntent.getBroadcast(this, 192837, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		 
		 // Get the AlarmManager service
		 AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
		 am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), sender);		
		
	//	getSystemService(Context.ALARM_SERVICE);
		
		((TextView)findViewById(R.id.theme)).setText(questionnaire.getTheme());
		next();

		
	}   
	

	
	public void next(){
		question = questionnaire.next();
		((TextView)findViewById(R.id.question)).setText(question.getTitre());
		((Button)findViewById(R.id.button_R1)).setText(question.getReponse(0));
		((Button)findViewById(R.id.button_R1)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				if (question.bonneReponse(0))
				Toast.makeText(Web1Activity.this, "Bonne réponse", Toast.LENGTH_SHORT).show();
				else Toast.makeText(Web1Activity.this, "Mauvaise réponse", Toast.LENGTH_SHORT).show();
				next();
			}
			});
		
		((Button)findViewById(R.id.button_R2)).setText(question.getReponse(1));
		((Button)findViewById(R.id.button_R2)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				if (question.bonneReponse(1))
				Toast.makeText(Web1Activity.this, "Bonne réponse", Toast.LENGTH_SHORT).show();
				else Toast.makeText(Web1Activity.this, "Mauvaise réponse", Toast.LENGTH_SHORT).show();
				next();
			}
			});
		
		((Button)findViewById(R.id.button_R3)).setText(question.getReponse(2));
		((Button)findViewById(R.id.button_R3)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				if (question.bonneReponse(2))
				Toast.makeText(Web1Activity.this, "Bonne réponse", Toast.LENGTH_SHORT).show();
				else Toast.makeText(Web1Activity.this, "Mauvaise réponse", Toast.LENGTH_SHORT).show();
				next();
			}
			});
		
		((Button)findViewById(R.id.button_R4)).setText(question.getReponse(3));
		((Button)findViewById(R.id.button_R4)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				if (question.bonneReponse(3))
				Toast.makeText(Web1Activity.this, "Bonne réponse", Toast.LENGTH_SHORT).show();
				else Toast.makeText(Web1Activity.this, "Mauvaise réponse", Toast.LENGTH_SHORT).show();
				next();
			}
			});
	}
	/* public boolean verification() {
    	if (currentTxt==t[0]){
    		return true;
    	}else{
    		return false;
    	}
	}*/


	private void lecture_xml() {
		String theme = null;
		String id = null;
		String titre = null;
		String currentTxt = null;
		int u=0;
		String[] reponse = new String[4];
		List<Question> setQuestion = new Vector<Question>();


		Resources res = getResources();
		XmlResourceParser xpp = res.getXml(R.xml.animaux);
		try {
			xpp.next();
			int eventType = xpp.getEventType();
			while (eventType != XmlPullParser.END_DOCUMENT) {
				if (eventType == XmlPullParser.TEXT) {
					currentTxt=xpp.getText();
				}
				if (eventType == XmlPullParser.END_TAG) {
					if (xpp.getName().equals("theme")) {
						theme=currentTxt;
					}
					else if (xpp.getName().equals("identifiant")) { // utiliser equals au lieu de == pour les chaines.
						id=currentTxt;
					}
					else if (xpp.getName().equals("titre")) {
						titre=currentTxt;
					}
					else if (xpp.getName().equals("reponse")) {
						reponse[u]=currentTxt;
						u=u+1;
					}
					else if (xpp.getName().equals( "question")) {
						Question question = new Question(titre, reponse);
						setQuestion.add(question);
						u=0;
						reponse = new String[4]; // ne pas oublier de cr�er un noveau tableau, sinon on modifie l'ancien !
					}
					else if (xpp.getName().equals("questionnaire")) {
						questionnaire = new Questionnaire(theme, id, setQuestion);
					}
				}
				eventType = xpp.next();

			}
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}



	}

}

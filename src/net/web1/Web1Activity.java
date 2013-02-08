package net.web1;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Web1Activity extends Activity {
	private Questionnaire questionnaire;
	private Question question;


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		lecture_xml();
		
		((TextView)findViewById(R.id.theme)).setText(questionnaire.getTheme());
		Question question = questionnaire.next();
		((TextView)findViewById(R.id.question)).setText(question.getTitre());
		((Button)findViewById(R.id.button_R1)).setText(question.getReponse(0));
		((Button)findViewById(R.id.button_R2)).setText(question.getReponse(1));
		((Button)findViewById(R.id.button_R3)).setText(question.getReponse(2));
		((Button)findViewById(R.id.button_R4)).setText(question.getReponse(3));
		
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
						reponse = new String[4]; // ne pas oublier de créer un noveau tableau, sinon on modifie l'ancien !
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

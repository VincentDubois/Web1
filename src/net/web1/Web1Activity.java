package net.web1;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;

public class Web1Activity extends Activity {
	private Questionnaire questionnaire;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		lecture_xml(R.xml.animaux);
		lecture_xml(R.xml.cinema);
	}

	private void lecture_xml(int fichier) {
		String theme = null;
		String id = null;
		String titre = null;
		String currentTxt = null;
		int u = 0;
		String[] reponse = new String[4];
		List<Question> setQuestion = new Vector<Question>();

		Resources res = getResources();
		
		XmlResourceParser xpp = res.getXml(fichier);
		try {
			xpp.next();
			int eventType = xpp.getEventType();
			while (eventType != XmlPullParser.END_DOCUMENT) {
				if (eventType == XmlPullParser.TEXT) {
					currentTxt = xpp.getText();
				}
				if (eventType == XmlPullParser.END_TAG) {
					if (xpp.getName().equals("theme")) {
						theme = currentTxt;
					} else if (xpp.getName() == "identifiant") {
						id = currentTxt;
					} else if (xpp.getName() == "titre") {
						titre = currentTxt;
					} else if (xpp.getName() == "reponse") {
						reponse[u] = currentTxt;
						u = u + 1;
					} else if (xpp.getName() == "question") {
						u = 0;
						Question question = new Question(titre, reponse);
						setQuestion.add(question);
					} else if (xpp.getName() == "questionnaire") {
						questionnaire = new Questionnaire(theme, id,
								setQuestion);
					}
					eventType = xpp.next();
				}

			}
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
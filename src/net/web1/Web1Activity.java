package net.web1;

import org.xmlpull.v1.XmlPullParser;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;

public class Web1Activity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		String theme;
		String id;
		String titre;
		String currentTxt;
		

		Resources res = getResources();
		XmlResourceParser xpp = res.getXml(R.xml.myxml);
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
				else if (xpp.getName() == "identifiant") {
					id=currentTxt;
				}
			
				
				
				// stringBuffer.append("\nEND_TAG: " + xpp.getName());
				// stringBuffer.append("\nTEXT: " + xpp.getText());
				eventType = xpp.next();
			}

		}
	}
}
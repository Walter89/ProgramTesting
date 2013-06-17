package com.example.placefinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button testbtn = (Button) findViewById(R.id.Testbtn);
		testbtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {

				// Execute HTTP Post Request
				JSONObject json;
				try {
					json = URLToJSONObject("http://api.wikilocation.org/articles?lat=55.704167&lng=13.193611");
					
					JSONArray articles = json.getJSONArray("articles");

//					for (int i = 0; i < articles.length(); ++i) {
						JSONObject article = articles.getJSONObject(0);
//						System.out.println("new print!");
//						System.out.println("JSON article title: "
//								+ article.getString("title"));
//						System.out.println("JSON article URL: "
//								+ article.getString("url") + "\n");
//					}
						String htmlResult = URLToString(article.getString("url"));
						
					 System.out.println("Hej"+json.length());
					 System.out.println("HTML Resultat:"+htmlResult);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public JSONObject URLToJSONObject(String URL) throws ClientProtocolException, JSONException, IOException
		 {
	

		JSONObject json = new JSONObject(URLToString(URL));

		return json;

	}
	
	public String URLToString(String URL)
			throws ClientProtocolException, IOException, JSONException {
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(URL);

		HttpResponse response = httpclient.execute(httpGet);

		HttpEntity ht = response.getEntity();

		BufferedHttpEntity buf = new BufferedHttpEntity(ht);

		InputStream is = buf.getContent();

		BufferedReader r = new BufferedReader(new InputStreamReader(is));

		StringBuilder total = new StringBuilder();
		String line;
		while ((line = r.readLine()) != null) {
			total.append(line);
		}

		

		return total.toString();

	}

}

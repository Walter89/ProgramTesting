package com.example.placefinder;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class ShowArticle extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showarticle);
		WebView myWebView = (WebView) findViewById(R.id.webview);
		Bundle bundle = getIntent().getExtras();
		myWebView.loadUrl(bundle.getString("key"));
	}
	
	
	

}

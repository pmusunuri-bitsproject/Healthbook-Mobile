package com.example.healthbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView healthbookWebView;
    private static final String STARTUP_URL = "https://healthbook-ui.et.r.appspot.com/#signin";
    private static final String USER_AGENT = "Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Mobile Safari/537.36";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        healthbookWebView = (WebView) findViewById(R.id.healthbookWebView);
        healthbookWebView.clearCache(true);
        healthbookWebView.getSettings().setJavaScriptEnabled(true);
        healthbookWebView.setWebViewClient(new WebViewClient());
        healthbookWebView.addJavascriptInterface(new HealthbookJavascriptInterface(MainActivity.this, this), "Healthbook");
        healthbookWebView.loadUrl(MainActivity.STARTUP_URL);
        Log.i("USERAGENT_PRANAV:", healthbookWebView.getSettings().getUserAgentString());
        healthbookWebView.getSettings().setUserAgentString(MainActivity.USER_AGENT);

    }
}
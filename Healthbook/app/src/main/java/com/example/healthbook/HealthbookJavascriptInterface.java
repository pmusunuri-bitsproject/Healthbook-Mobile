package com.example.healthbook;

import android.app.Activity;
import android.content.Context;
import android.webkit.JavascriptInterface;

public class HealthbookJavascriptInterface {
    private Context context;
    private Activity activity;

    public HealthbookJavascriptInterface(Context context, Activity activity){
        this.context = context;
        this.activity = activity;
    }

    @JavascriptInterface
    public void stop(){
        activity.finish();
    }
}

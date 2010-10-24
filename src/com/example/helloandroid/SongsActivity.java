package com.example.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SongsActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("patrick-code", "SongsActivity onCreate started");
        TextView textview = new TextView(this);
        textview.setText("This is the Songs tab");
        setContentView(textview);
    }
}
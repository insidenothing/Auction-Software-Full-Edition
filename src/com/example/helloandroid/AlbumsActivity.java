package com.example.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class AlbumsActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("patrick-code", "AlbumsActivity onCreate started");
        TextView textview = new TextView(this);
        textview.setText("This is the Albums tab");
        setContentView(textview);
    }
}
package com.auction.software;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ArtistsActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("patrick-code", "Loaded 'Around Me Now' Tab");
        TextView textview = new TextView(this);
        textview.setText("'Around Me Now' is in development.");
        setContentView(textview);
    }
}
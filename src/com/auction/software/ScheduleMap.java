package com.auction.software;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ScheduleMap extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("patrick-code", "full edition holder");
        TextView textview = new TextView(this);
        textview.setText("'Around Me Now' will be included in the next version release. I am working on it every night. You can contact me at insidenothing@gmail.com with any feedback.");
        setContentView(textview);
    }
}
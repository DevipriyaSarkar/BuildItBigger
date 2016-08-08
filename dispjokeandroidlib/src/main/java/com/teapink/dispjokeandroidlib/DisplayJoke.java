package com.teapink.dispjokeandroidlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJoke extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        String joke = getIntent().getExtras().getString("jokePassed");

        TextView jokeTextView = (TextView) findViewById(R.id.jokeTextView);
        jokeTextView.setText(joke);

    }
}

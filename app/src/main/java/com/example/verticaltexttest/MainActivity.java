package com.example.verticaltexttest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = findViewById(R.id.LinearLayout);

        VerticalTextView textView = new VerticalTextView(this);
        textView.setBackgroundColor(Color.WHITE);
        textView.setWidth(800);
        textView.setHeight(600);
        textView.setFontSize(48);
        textView.setText("ABCDEFG正");
        textView.initPaint();

        linearLayout.addView(textView);
    }
}
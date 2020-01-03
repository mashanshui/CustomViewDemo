package com.shanshui.customviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        DisplayMetrics displayMetrics2 = this.getResources().getDisplayMetrics();
//        displayMetrics2.scaledDensity = 20;
        setContentView(R.layout.activity_main);
    }
}

package com.shanshui.customviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        DisplayMetrics displayMetrics2 = this.getResources().getDisplayMetrics();
//        displayMetrics2.scaledDensity = 20;
        setContentView(R.layout.activity_main);
//        WebView webView = findViewById(R.id.webView);
//        webView.getSettings().setJavaScriptEnabled(true);
//        WebSettings settings = webView.getSettings();
//        settings.setTextZoom(150); // 通过百分比来设置文字的大小，默认值是100
//        webView.setBackgroundColor(0); // 设置背景色
//        webView.getBackground().setAlpha(90);
//        webView.loadUrl("https://www.baidu.com");
//        FrameLayout frameLayout = findViewById(R.id.frameLayout);
//        frameLayout.setBackgroundColor(Color.parseColor("#50FFC1C1"));
    }
}

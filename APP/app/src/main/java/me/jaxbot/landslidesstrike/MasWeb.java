package me.jaxbot.landslidesstrike;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MasWeb extends AppCompatActivity {
WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas_web);
        web=(WebView) findViewById(R.id.webactivity);
        web.loadUrl("https://www.google.co.in/maps/@28.5476779,77.326688,15z?hl=en");
    }
}

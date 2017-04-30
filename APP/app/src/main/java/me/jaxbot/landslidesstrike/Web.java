package me.jaxbot.landslidesstrike;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class Web extends AppCompatActivity {
WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        web=(WebView) findViewById(R.id.webactivity);
        Intent i = getIntent();

        String uu = i.getStringExtra("url");
//        Toast.makeText(Web.this,uu,Toast.LENGTH_SHORT).show();
        web.loadUrl(uu);
    }
}

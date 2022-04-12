package com.example.staysafe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Loading extends AppCompatActivity {
ImageView icon,name,back;
    private static final int SPLASHTIME=5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        icon=findViewById(R.id.icon);
        name=findViewById(R.id.name);
        back=findViewById(R.id.back);


        back.animate().translationX(-1600).setDuration(1000).setStartDelay(4000);
        name.animate().translationX(1400).setDuration(1000).setStartDelay(4000);
        icon.animate().translationX(1400).setDuration(1000).setStartDelay(4000);
new Handler().postDelayed(() -> {
    Intent intent= new Intent(Loading.this,MainActivity.class);
    startActivity(intent);
    finish();
},SPLASHTIME);
    }
}
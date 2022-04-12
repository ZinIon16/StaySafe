package com.example.staysafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class End extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        setupHyperlink();
    }

    private void setupHyperlink() {
        TextView linkTextView = findViewById(R.id.myemail);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}

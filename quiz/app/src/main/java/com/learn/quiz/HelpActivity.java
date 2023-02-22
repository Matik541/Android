package com.learn.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class HelpActivity extends AppCompatActivity {

    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(view -> {
            back();
        });
    }

    private void back() {
        Intent intention = new Intent(this, MainActivity.class);
        startActivity(intention);
    }
}
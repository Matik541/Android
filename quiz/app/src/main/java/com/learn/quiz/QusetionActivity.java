package com.learn.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class QusetionActivity extends AppCompatActivity {

    Button checkButton;
    Button helpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkButton = findViewById(R.id.checkButton);
        checkButton.setOnClickListener(view -> {
            if(checkAnswers()){
                submitAnswers("Great guess!");
            }
            else {
                submitAnswers("Try again! No worries!");
            }
        });

        helpButton = findViewById(R.id.helpButton);
        helpButton.setOnClickListener(view -> {
            Intent intention = new Intent(this, HelpActivity.class);
            startActivity(intention);
//          explicit intention
        });
    }
    private boolean checkAnswers() {
        RadioGroup rg = findViewById(R.id.rg);
        rg.getCheckedRadioButtonId();
        return true;
    }

    private void submitAnswers(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
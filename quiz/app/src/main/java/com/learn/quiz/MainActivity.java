package com.learn.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        startButton = findViewById(R.id.startButton);
//        startButton.setOnClickListener(view -> {
//            Intent intention = new Intent(this, QusetionActivity.class);
//            startActivity(intention);
////          explicit intentio
//        });
    }

}
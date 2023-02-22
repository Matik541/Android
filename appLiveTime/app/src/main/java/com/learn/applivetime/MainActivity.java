package com.learn.applivetime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Integer counter = 0;

    ImageButton incButton;
    ImageButton decButton;

    TextView TextCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Live time", "onCreate() done");

        counter = (savedInstanceState != null) ? savedInstanceState.getInt("counter") : 0;

        incButton = findViewById(R.id.incButton);
        decButton = findViewById(R.id.decButton);

        TextCounter = findViewById(R.id.counter);

        changeCounter(0);
        incButton.setOnClickListener(v -> changeCounter(1));
        decButton.setOnClickListener(v -> changeCounter(-1));
    }

    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Live time", "onSaveInstanceState() done");
        outState.putInt("counter", counter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        save counter to local file
    }


    @SuppressLint("SetTextI18n")
    private void changeCounter(int value) {
        counter += value;
        TextCounter.setText(counter.toString());
    }

    private void saveCounter() {
        // save counter to local file
    }

}
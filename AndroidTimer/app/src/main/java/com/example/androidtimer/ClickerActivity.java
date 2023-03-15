package com.example.androidtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

public class ClickerActivity extends AppCompatActivity {

    int seconds = 0;
    boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicker);

        TextView timerText = findViewById(R.id.timer);
        Button actionBtn = findViewById(R.id.actionBtn);

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                if (running) {
                    seconds++;
                    timerText.setText(getResources().getString(R.string.timer) + (seconds));
                }

                handler.postDelayed(this, 1000);
            }
        });

        actionBtn.setOnClickListener(view -> {
            actionBtn.setText(getResources().getString((running) ? R.string.start: R.string.stop));
            running=!running;
        });
    }

}
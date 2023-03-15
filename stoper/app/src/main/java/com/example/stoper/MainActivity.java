package com.example.stoper;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
  int time;
  boolean running = false;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    time = (savedInstanceState != null) ? savedInstanceState.getInt("time") : 0;
    running =
      savedInstanceState != null && savedInstanceState.getBoolean("running");

    TextView timerText = findViewById(R.id.timerText);
    int s = time % 60;
    int m = time / 60 % 60;
    int h = time / 60 / 60;

    timerText.setText(
      ((h < 10) ? "0" : "") +
      h +
      ":" +
      ((m < 10) ? "0" : "") +
      m +
      ":" +
      ((s < 10) ? "0" : "") +
      s
    );

    final Handler handler = new Handler();
    handler.post(
      new Runnable() {

        @SuppressLint("SetTextI18n")
        @Override
        public void run() {
          if (running) {
            time++;

            int s = time % 60;
            int m = time / 60 % 60;
            int h = time / 60 / 60;

            timerText.setText(
              ((h < 10) ? "0" : "") +
              h +
              ":" +
              ((m < 10) ? "0" : "") +
              m +
              ":" +
              ((s < 10) ? "0" : "") +
              s
            );
          }

          handler.postDelayed(this, 1000);
        }
      }
    );

    Button startBtn = findViewById(R.id.startBtn);
    startBtn.setOnClickListener(
      new View.OnClickListener() {

        @Override
        public void onClick(View view) {
          running = !running;
          if (running) startBtn.setText("Stop"); else startBtn.setText("Start");
        }
      }
    );

    Button resetBtn = findViewById(R.id.resetBtn);
    resetBtn.setOnClickListener(
      new View.OnClickListener() {

        @Override
        public void onClick(View view) {
          time = 0;
          running = false;

          timerText.setText("00:00:00");
          startBtn.setText("Start");
        }
      }
    );

    Button sendBtn = findViewById(R.id.sendBtn);
    sendBtn.setOnClickListener(
      new View.OnClickListener() {

        @Override
        public void onClick(View view) {
          int s = time / 100 % 60;
          int m = time / 100 / 60 % 60;
          int h = time / 100 / 60 / 60;

          TextView tempToast = findViewById(R.id.tempToast);
          tempToast.setText("Tiem" + time);
          Toast
            .makeText(MainActivity.this, "Time" + time, Toast.LENGTH_SHORT)
            .show();
        }
      }
    );
  }

  protected void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putInt("time", time);
    outState.putBoolean("running", running);
  }
}

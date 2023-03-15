package com.example.androidtimer;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

public class Player {
    private TextView timerText;

    private CountDownTimer timer;

    private int seconds = 20;
    private boolean running = false;

    public Player(TextView timerText) {
        this.timerText = timerText;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void startTimer() {
        timer = new CountDownTimer(seconds*1000, 1000) {
            @Override
            public void onTick(long l) {
                seconds = (int) l/1000;
                showTimeLeft();
            }

            @Override
            public void onFinish() {
                timerText.setText(R.string.end);
            }
        };

        timer.start();
        running = true;
    }

    public void stopTimer() {
        timer.cancel();
        running = false;
    }

    @SuppressLint("DefaultLocale")
    private void showTimeLeft() {
        timerText.setText(String.format("%02d:%02d", seconds/60, seconds%60));
        if(seconds < 15) {
//            change text color to red
            timerText.setTextColor();
        }
    }


}

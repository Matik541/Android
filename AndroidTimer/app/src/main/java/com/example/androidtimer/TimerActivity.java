package com.example.androidtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TimerActivity extends AppCompatActivity {

    Pair<Player, Player> players;

    Button button1;
    Button button2;

    int turn = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        players = new Pair<>(
            new Player(findViewById(R.id.player1Timer)),
            new Player(findViewById(R.id.player2Timer))
        );

        button1 = findViewById(R.id.player1Btn);
        button2 = findViewById(R.id.player2Btn);

        players.second.startTimer();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button1.setEnabled(false);
                button2.setEnabled(true);

                if(turn % 2 == 0){
                    players.second.stopTimer();
                    players.first.startTimer();
                }
                else {
                    players.first.stopTimer();
                    players.second.startTimer();
                }

                turn++;
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button1.setEnabled(true);
                button2.setEnabled(false);

                if(turn % 2 == 0){
                    players.second.stopTimer();
                    players.first.startTimer();
                }
                else {
                    players.first.stopTimer();
                    players.second.startTimer();
                }

                turn++;
            }
        });

    }
}
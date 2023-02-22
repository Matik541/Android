package com.example.dice3pgr2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private final ArrayList<ImageView> dicesView = new ArrayList<>();
    private final ArrayList<Dice> dices = new ArrayList<>();

    public void rollDice() {
        if (dices.size() == 0)
            for (int i = 0; i < dicesView.size(); i++) {
                Dice dice = new Dice();
                dices.add(dice);
                dicesView.get(i).setImageResource(dice.getIdImage());
            }
        else
            for (int i = 0; i < dicesView.size(); i++)
                if (!dices.get(i).isClicked()) {
                    Dice dice = new Dice();
                    dices.set(i, dice);
                    dicesView.get(i).setImageResource(dice.getIdImage());
                }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button diceButton = findViewById(R.id.button);

        dicesView.add(findViewById(R.id.imageView1));
        dicesView.add(findViewById(R.id.imageView2));
        dicesView.add(findViewById(R.id.imageView3));
        dicesView.add(findViewById(R.id.imageView4));
        dicesView.add(findViewById(R.id.imageView5));

        rollDice();

        diceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();

                Integer score = 0;
                int[] count = new int[6];

                for (int i = 0; i < dices.size(); i++)
                    count[dices.get(i).getValue() - 1]++;

                boolean isFiveOfAKind = false;
                boolean isFourOfAKind = false;
                boolean isFullHouse = false;
                boolean isThreeOfAKind = false;
                boolean isTwoPairs = false;
                boolean isPair = false;
                int straight = 0;

                for (int j : count) {
                    if (j == 5)
                        isFiveOfAKind = true;
                    if (j == 4)
                        isFourOfAKind = true;
                    if (j == 3)
                        isThreeOfAKind = true;

                    if (j == 2) {
                        isFullHouse = true;
                        if (isPair)
                            isTwoPairs = true;
                        isPair = true;
                    }
                    if (j == 1) {
                        isFullHouse = false;
                        straight++;
                    }
                }

                if (isFiveOfAKind)
                    score = 50;
                else if (isFourOfAKind)
                    score = 40;
                else if (isFullHouse && isThreeOfAKind)
                    score = 30;
                else if (straight == 6)
                    score = 20;
                else if (isThreeOfAKind)
                    score = 10;
                else if (isTwoPairs)
                    score = 5;
                else if (isPair)
                    score = 2;
                else
                    score = 1;

                TextView scoreText = findViewById(R.id.textView);
                scoreText.setText(getResources().getString(R.string.score) + score);
            }
        });

        for (int i = 0; i < dicesView.size(); i++) {
            int finalI = i;
            dicesView.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (dices.get(finalI).isClicked()) {
                        dices.get(finalI).setClicked(false);
                        dicesView.get(finalI).setImageAlpha(255);
                    } else {
                        dices.get(finalI).setClicked(true);
                        dicesView.get(finalI).setImageAlpha(50);
                    }
                }
            });
        }
    }
}
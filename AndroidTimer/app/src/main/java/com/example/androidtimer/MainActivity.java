package com.example.androidtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int seconds = 10;
    private int points = 0;

    private ArrayList<ImageView> imagesList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView timerText = findViewById(R.id.timer);

        imagesList.add(findViewById(R.id.imageView0));
        imagesList.add(findViewById(R.id.imageView1));
        imagesList.add(findViewById(R.id.imageView2));
        imagesList.add(findViewById(R.id.imageView3));

        showRandomImage();

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                if(seconds > 0) {
                    seconds--;
                    showRandomImage();
                    timerText.setText(getResources().getString(R.string.timer) + (seconds));
                }

                handler.postDelayed(this, 1000);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void showRandomImage() {
        for (ImageView image : imagesList) {
            image.setVisibility(View.INVISIBLE);
        }

        int index = (int)(Math.random()* imagesList.size());
        imagesList.get(index).setVisibility(View.VISIBLE);
        imagesList.get(index).setOnClickListener(view -> {
            points++;
            TextView pointsText = findViewById(R.id.points);
            pointsText.setText(getResources().getString(R.string.points) + (points) );
            showRandomImage();
        });
    }



}
package com.example.basketballl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.basketballl.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    ViewModelPoints scores;
    private SharedPreferences scoresPreferences;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        scores = new ViewModelProvider(this).get(ViewModelPoints.class);
        readPreferences();

        scores.getScoreA().observe(this, score -> binding.scoreA.setText(score.toString()));
        scores.getScoreB().observe(this, score -> binding.scoreB.setText(score.toString()));

        binding.btnA1.setOnClickListener(v -> scores.addScoreA(1) );
        binding.btnA2.setOnClickListener(v -> scores.addScoreA(2) );
        binding.btnA3.setOnClickListener(v -> scores.addScoreA(3) );

        binding.btnB1.setOnClickListener(v -> scores.addScoreB(1) );
        binding.btnB2.setOnClickListener(v -> scores.addScoreB(2) );
        binding.btnB3.setOnClickListener(v -> scores.addScoreB(3) );
    }

    @Override
    protected void onPause() {
        super.onPause();
        writePreferences();
    }

    private void writePreferences(){
        scoresPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = scoresPreferences.edit();
        editor.putInt("scoreA", scores.getScoreA().getValue());
        editor.putInt("scoreB", scores.getScoreB().getValue());
        editor.apply();
    }

    private void readPreferences(){
        scoresPreferences = getPreferences(MODE_PRIVATE);
        scores.setScoreA(new MutableLiveData<>(scoresPreferences.getInt("scoreA", 0)));
        scores.setScoreB(new MutableLiveData<>(scoresPreferences.getInt("scoreB", 0)));
    }

}
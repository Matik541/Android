package com.learn.exam1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button roll;
    Button increase;
    Button decrease;

    TextView rollText;

    int rolledValue = 0;
    boolean canCange = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roll = findViewById(R.id.roll_button);
        increase = findViewById(R.id.increase_button);
        decrease = findViewById(R.id.decrease_button);

        rollText = findViewById(R.id.roll_text);

        if (savedInstanceState != null) {
            rolledValue = savedInstanceState.getInt("rolledValue");
            canCange = savedInstanceState.getBoolean("canCange");
            if (rolledValue != 0) {
                rollText.setText(String.valueOf(rolledValue));
                if (canCange) {
                    increase.setVisibility(View.VISIBLE);
                    decrease.setVisibility(View.VISIBLE);
                }
            }
        }

        roll.setOnClickListener(v -> {
            rolledValue = (int) (Math.random() * 6) + 1;
            rollText.setText(String.valueOf(rolledValue));

            increase.setVisibility(View.VISIBLE);
            decrease.setVisibility(View.VISIBLE);
        });

        increase.setOnClickListener(v -> {
            if (rolledValue < 6) {
                rolledValue++;
                rollText.setText(String.valueOf(rolledValue));
                increase.setVisibility(View.INVISIBLE);
                decrease.setVisibility(View.INVISIBLE);
                canCange = false;
            }
            else {
                Toast.makeText(MainActivity.this, R.string.value_7, Toast.LENGTH_SHORT).show();
            }
        });
        decrease.setOnClickListener(v -> {
            if (rolledValue > 1) {
                rolledValue--;
                rollText.setText(String.valueOf(rolledValue));
                increase.setVisibility(View.INVISIBLE);
                decrease.setVisibility(View.INVISIBLE);
                canCange = false;
            }
            else {
                Toast.makeText(MainActivity.this, R.string.value_0, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("rolledValue", rolledValue);
        outState.putBoolean("canCange", canCange);
    }
}
package com.learn.penguingallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> images = new ArrayList<>();
    ImageView imageView;
    int index = 0;

    LinearLayout layout;

    Button nextButton;
    Button prevButton;

    EditText editText;

    Switch bgSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 1; i <= 7; i++)
            images.add(getResources().getIdentifier("penguin" + i, "drawable", getPackageName()));

        imageView = findViewById(R.id.imageView);

        nextButton = findViewById(R.id.next);
        prevButton = findViewById(R.id.prev);

        nextButton.setOnClickListener(v -> {
            index = (index + 1) % images.size();
            imageView.setImageResource(images.get(index));
        });
        prevButton.setOnClickListener(v -> {
            index = (index - 1 + images.size()) % images.size();
            imageView.setImageResource(images.get(index));
        });

        editText = findViewById(R.id.inputImage);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int input = Integer.parseInt(s.toString());
                    if (input > 0 && input <= images.size())
                        imageView.setImageResource(images.get(input - 1));
                } catch (Exception ignored) { }
            }
        });

        layout = findViewById(R.id.layout);
        bgSwitch = findViewById(R.id.bgSwitch);
        bgSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                layout.setBackgroundColor(getResources().getColor(R.color.blue));
            else
                layout.setBackgroundColor(getResources().getColor(R.color.light));
        });


    }
}
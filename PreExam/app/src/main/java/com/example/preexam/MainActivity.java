package com.example.preexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ArrayList<String> arrayList = new ArrayList<>();

		arrayList.add("A");
		arrayList.add("B");
		arrayList.add("C");
		arrayList.add("D");

		Spinner spinner = findViewById(R.id.spinner);
		ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrayList);
		spinner.setAdapter(listAdapter);
		// progress * 8
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(MainActivity.this, "Selected: " + arrayList.get(position), Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});

	}
}
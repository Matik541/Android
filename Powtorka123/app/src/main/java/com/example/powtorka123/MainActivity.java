package com.example.powtorka123;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> books = new ArrayList<>(); // array

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        books.add("a");
        books.add("b");
        books.add("c");
        books.add("d");
        books.add("e");
        books.add("f");
        books.add("c");

        // nowy adapter
        ArrayAdapter<String> adapterBooks = new ArrayAdapter<>(
            MainActivity.this, // MainActivity.this lub zwykłe this
            android.R.layout.simple_list_item_1, // ma być.
            books // array wyżej
        );

        // nowa aktywność (click item) - ListView
        AdapterView.OnItemClickListener clickedBook = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Removed book: "+books.get(i), Toast.LENGTH_SHORT).show();
                books.remove(i); // usuwanie po ID
                adapterBooks.notifyDataSetChanged();
            }
        };

        // nowa aktywność (select item) - Spinner
        AdapterView.OnItemSelectedListener selectedBook = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Removed book: "+books.get(i), Toast.LENGTH_SHORT).show();
                books.remove(i); // usuwanie po ID
                adapterBooks.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        };

        ListView lista = findViewById(R.id.lista);
        lista.setAdapter(adapterBooks); // przypisanie adaptera

        lista.setOnItemClickListener(clickedBook); // dodanie aktywności (click)
        // lista.setOnItemSelectedListener(selectedBook); // dodanie aktywności (select)

        // nowa aktywnośc (click)
        View.OnClickListener addBook = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = findViewById(R.id.bookName);
                books.add(name.getText().toString());
                name.setText("");

                adapterBooks.notifyDataSetChanged();
            }
        };

        Button addBtn = findViewById(R.id.button);
        addBtn.setOnClickListener(addBook); // przypisanie aktywności
    }
}
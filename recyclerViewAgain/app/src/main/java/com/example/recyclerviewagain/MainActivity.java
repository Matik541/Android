package com.example.recyclerviewagain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    /*
    in: gradle add: dependencies { ... implementation 'androidx.recyclerview:recyclerview:1.2.1' }

    in: res/layout - new > Layout resorce file
        ustawiamy layout obiektu

    if needed:
        in: java - new > Java class (new objectClass)

    in: java - new > Java class (new adapter)

    add: *nazwa*Recycler
    */

    LinkedList<Book> booksList = new LinkedList<>();

    RecyclerView booksRecycler;
    BooksAdapter booksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        booksList.add(new Book("abc", "cba"));
        booksList.add(new Book("abc", "cba"));
        booksList.add(new Book("abc", "cba"));
        booksList.add(new Book("abc", "cba"));
        booksList.add(new Book("abc", "cba"));
        booksList.add(new Book("abc", "cba"));
        booksList.add(new Book("abc", "cba"));
        booksList.add(new Book("abc", "cba"));
        booksList.add(new Book("abc", "cba"));
        booksList.add(new Book("abc", "cba"));
        booksList.add(new Book("abc", "cba"));
        booksList.add(new Book("abc", "cba"));
        booksList.add(new Book("abc", "cba"));
        booksList.add(new Book("abc", "cba"));
        booksList.add(new Book("abc", "cba"));
        booksList.add(new Book("abc", "cba"));
        booksList.add(new Book("abc", "cba"));
        booksList.add(new Book("abc", "cba"));
        booksList.add(new Book("abc", "cba"));
        booksList.add(new Book("abc", "cba"));
        booksList.add(new Book("abc", "cba"));
        booksList.add(new Book("abc", "cba"));

        /*
            *object*Recycler = xml id
            *object*Adapter = new *nazwa*Adapter
            *object*Recycler.setAdapter(*object*Adapter)
            *object*Recycler.serLayoutManager( new LinearLayoutManager(this) )
        */
        booksRecycler = findViewById(R.id.chujemuje);
        booksAdapter = new BooksAdapter(this, booksList);
        booksRecycler.setAdapter(booksAdapter);
        booksRecycler.setLayoutManager(new LinearLayoutManager(this));

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = findViewById(R.id.editTextTextPersonName);
                booksList.add(new Book(name.getText().toString(), "a"));
                booksAdapter.notifyDataSetChanged();
            }
        });
    }
}
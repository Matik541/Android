package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    LinkedList<Product> shoppingList = new LinkedList<>();
    RecyclerView shoppingRecycler;
    ShoppingAdapter shoppingAdapter;

    private void listTemplate() {
        shoppingList.add(new Product("water"));
        shoppingList.add(new Product("rice"));
        shoppingList.add(new Product("milk"));
        shoppingList.add(new Product("oil"));
        shoppingList.add(new Product("bread"));
        shoppingList.add(new Product("eggs"));
        shoppingList.add(new Product("beef"));
        shoppingList.add(new Product("water"));
        shoppingList.add(new Product("rice"));
        shoppingList.add(new Product("milk"));
        shoppingList.add(new Product("oil"));
        shoppingList.add(new Product("bread"));
        shoppingList.add(new Product("eggs"));
        shoppingList.add(new Product("beef"));
        shoppingList.add(new Product("rice"));
        shoppingList.add(new Product("water"));
        shoppingList.add(new Product("milk"));
        shoppingList.add(new Product("oil"));
        shoppingList.add(new Product("bread"));
        shoppingList.add(new Product("eggs"));
        shoppingList.add(new Product("beef"));
        shoppingList.add(new Product("water"));
        shoppingList.add(new Product("rice"));
        shoppingList.add(new Product("milk"));
        shoppingList.add(new Product("oil"));
        shoppingList.add(new Product("bread"));
        shoppingList.add(new Product("eggs"));
        shoppingList.add(new Product("beef"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listTemplate();

        shoppingRecycler = findViewById(R.id.shoppingRecycler);
        shoppingAdapter = new ShoppingAdapter(this, shoppingList);
        shoppingRecycler.setAdapter(shoppingAdapter);
        shoppingRecycler.setLayoutManager(new LinearLayoutManager(this));

        Button removeBtn = findViewById(R.id.removeBtn);
        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoppingAdapter.selectedItemsRemove();
                Toast.makeText(MainActivity.this, "Delete", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
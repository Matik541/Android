package com.example.cookingbook;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RecipesListActivity extends AppCompatActivity {

    public static String extraRecipeID = "recipe";
    public static String extraCategory = "category";

    Integer category = 0;
    ArrayAdapter<Recipe> adapter;

    TextView text;
    FloatingActionButton add;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_list);

        category = getIntent().getIntExtra("category", 0);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, RecipesList.getRecipesByCategory(category));
        ListView list = findViewById(R.id.list);
        list.setAdapter(adapter);

        text = findViewById(R.id.category);
        text.setText(getResources().getText(R.string.category) + getResources().getStringArray(R.array.categories)[category]);

        list.setOnItemClickListener(
            (parent, view, position, id) -> openRecipe(position)
        );

        add = findViewById(R.id.add);
        add.setOnClickListener(
            v -> openAddRecipe()
        );
    }

    public void openRecipe(int recipeID) {
        Intent intent = new Intent(this, RecipeActivity.class);
        intent.putExtra(extraRecipeID, recipeID);
        intent.putExtra(extraCategory, category);
        startActivity(intent);
    }

    public void openAddRecipe() {
        Intent intent = new Intent(this, AddRecipeActivity.class);
        intent.putExtra(extraCategory, category);
        startActivity(intent);
        adapter.notifyDataSetChanged();
    }
}
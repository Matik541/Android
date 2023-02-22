package com.example.cookingbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddRecipeActivity extends AppCompatActivity {

    int category;

    TextView name;
    TextView ingredients;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        category = getIntent().getIntExtra(RecipesListActivity.extraCategory, 0);

        name = findViewById(R.id.name);
        ingredients = findViewById(R.id.ingredients);
        add = findViewById(R.id.add);

        add.setOnClickListener(
                v -> addRecipe()
        );
    }

    public void addRecipe() {
        Recipe recipe = new Recipe(name.getText().toString(), category, ingredients.getText().toString(), R.drawable.ic_cookie_foreground);
        RecipesList.addRecipe(recipe);
        finish();
    }
}
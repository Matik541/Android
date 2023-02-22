package com.example.cookingbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecipesList.addRecipe(new Recipe("płatki", 0, "płatki, mleko", R.drawable.platki1));
        RecipesList.addRecipe(new Recipe("tosty", 0, "chleb, masło", R.drawable.tosty1));
        RecipesList.addRecipe(new Recipe("pierogi", 1, "mąka, jajka", R.drawable.pierogi1));
        RecipesList.addRecipe(new Recipe("pizza", 1, "ciasto, ser", R.drawable.pizza1));
        RecipesList.addRecipe(new Recipe("tort czekoladowy", 2, "mąka, jajka, chekolada", R.drawable.tort1));
        RecipesList.addRecipe(new Recipe("herbata", 3, "woda, torebka herbaty", R.drawable.herbata1));

        list = findViewById(R.id.list);
        list.setOnItemClickListener(
            (parent, view, position, id) -> openCookingList(position)
        );
    }

    public void openCookingList(int category) {
        Intent intent = new Intent(this, RecipesListActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }
}
package com.example.cookingbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    int recipeID = 0;
    int category = 0;

    ImageView image;
    TextView name;
    TextView ingredients;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        recipeID = getIntent().getIntExtra(RecipesListActivity.extraRecipeID, 0);
        category = getIntent().getIntExtra(RecipesListActivity.extraCategory, 0);

        Recipe recipe = RecipesList.getRecipesByCategory(category).get(recipeID);

        image = findViewById(R.id.image);
        name = findViewById(R.id.name);
        ingredients = findViewById(R.id.ingredients);
        send = findViewById(R.id.send);

        image.setImageResource(recipe.getImage());
        name.setText(recipe.getName());
        ingredients.setText(recipe.getIngredients());

        send.setOnClickListener(
            v -> shareRecipe(recipe)
        );

    }
    public void shareRecipe(Recipe recipe) {
//        manifest -> add permission to share (SEND action)
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, getResources().getText(R.string.shareContent) + "\n\""+ recipe.getName() + "\", \n" + recipe.getIngredients() + "\n" + getResources().getText(R.string.shareEnjoy));
        Intent share = Intent.createChooser(intent, getResources().getText(R.string.share));
        startActivity(share);
    }
}
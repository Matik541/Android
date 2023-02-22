package com.example.cookingbook;

import java.util.ArrayList;

public class RecipesList {
    private static ArrayList<Recipe> recipes = new ArrayList<>();
    public static ArrayList<Recipe> getRecipesByCategory(int category) {
        ArrayList<Recipe> recipesByCategory = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.getCategory() == category) {
                recipesByCategory.add(recipe);
            }
        }
        return recipesByCategory;
    }

    public static void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public static void removeRecipe(Recipe recipe) {
        recipes.remove(recipe);
    }
}
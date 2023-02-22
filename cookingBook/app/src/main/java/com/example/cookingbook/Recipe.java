package com.example.cookingbook;

import androidx.annotation.NonNull;

public class Recipe {
    private String name;
    private int category;
    private String ingredients;
    private int image;

    public Recipe(String name, int category, String ingredients, int image) {
        this.name = name;
        this.category = category;
        this.ingredients = ingredients;
        this.image = image;
    }

    public String getName() {
        return name;
    }
    public int getCategory() {
        return category;
    }
    public String getIngredients() {
        return ingredients;
    }
    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(int category) {
        this.category = category;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public void setImage(int image) {
        this.image = image;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}

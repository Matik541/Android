package com.example.recyclerview;

public class Product {
    private String name;
    private boolean isChecked = false;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + isChecked;
    }

    public String getName() {
        return name;
    }
    public boolean isChecked() {
        return isChecked;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}

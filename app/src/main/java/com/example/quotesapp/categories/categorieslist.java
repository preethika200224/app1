package com.example.quotesapp.categories;

public class categorieslist {
    private final String categoryName;
    private final int categoryImg;

    public categorieslist(String categoryName, int categoryImg) {
        this.categoryName = categoryName;
        this.categoryImg = categoryImg;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryImg() {
        return categoryImg;
    }
}

package com.example.quotesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.quotesapp.categories.categoriesAdapter;
import com.example.quotesapp.categories.categorieslist;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private final List<categorieslist> categoriesLists= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView categoriesRecyclerView= findViewById(R.id.categoriesRecyclerView);
        categoriesRecyclerView.setHasFixedSize(true);
        categoriesRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,  2));
        // add categories to  categoriesLists
        categorieslist loveCategory= new categorieslist("Love", R.drawable.main );
        categoriesLists.add(loveCategory);

        // add categories to  categoriesLists
        categorieslist motivationCategory= new categorieslist("Motivation", R.drawable.second );
        categoriesLists.add(motivationCategory);

        // add categories to  categoriesLists
        categorieslist englishCategory= new categorieslist("English", R.drawable.third );
        categoriesLists.add(englishCategory);

        // add categories to  categoriesLists
        categorieslist successCategory= new categorieslist("Success", R.drawable.fourth );
        categoriesLists.add(successCategory);

        // add categories to  categoriesLists
        categorieslist lifeCategory= new categorieslist("Life", R.drawable.fivth );
        categoriesLists.add(lifeCategory);

        //set adapter to recycler view
        categoriesRecyclerView.setAdapter(new categoriesAdapter(categoriesLists, MainActivity.this));

    }
}

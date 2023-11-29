package com.example.quotesapp;

import static com.example.quotesapp.quoteslist.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class quotes extends AppCompatActivity {
    private TextView quoteTxt, writerName;

    private final List <quoteslist> quotesLists= new ArrayList<>();
    private int currentQuotePosition=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        final TextView categoryName = findViewById(R.id.categoryName);
        quoteTxt =findViewById(R.id.quoteTxt);
        writerName = findViewById(R.id.writerName);
        final Button prevBtn=findViewById(R.id.prevBtn);
        final Button nextbtn= findViewById(R.id.nextbtn);
        final ImageView copyBtn= findViewById(R.id.copyBtn);

        //get category name from categoryAdapter class
        final String getName= getIntent().getStringExtra("name");

        categoryName.setText(getName);

        if(getName.equals("Life")){
            quotesLists.addAll(QuotesData.getLifeQuotes());
        }
        else if(getName.equals("Success")){
            quotesLists.addAll(QuotesData.getsuccessQuotes());
        }
        else if(getName.equals("Motivation")){
            quotesLists.addAll(QuotesData.getmotivationQuotes());
        }
        else if(getName.equals("Love")){
            quotesLists.addAll(QuotesData.getLoveQuotes());
        }
        else if(getName.equals("English")){
            quotesLists.addAll(QuotesData.getenglishQuotes());
        }



       setQuoteToTextView();
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentQuotePosition--;

                if(currentQuotePosition < 0){
                    currentQuotePosition = quotesLists.size()-1;
                }
                setQuoteToTextView();
            }
        });

        copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData= ClipData.newPlainText("quote", quotesLists.get(currentQuotePosition).getQuote()+"\nby"+quotesLists.get(currentQuotePosition).getWriter());
                clipboardManager.setPrimaryClip(clipData);
            }
        });
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentQuotePosition++;

                if(currentQuotePosition >= quotesLists.size()){
                    currentQuotePosition=0;
                }
                setQuoteToTextView();
            }
        });
    }
    private void setQuoteToTextView(){
        quoteTxt.setText(quotesLists.get(currentQuotePosition).getQuote());

        writerName.setText(quotesLists.get(currentQuotePosition).getWriter());
    }

}
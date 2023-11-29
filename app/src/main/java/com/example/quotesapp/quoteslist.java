package com.example.quotesapp;

import java.util.List;

public class quoteslist {
    private final String quote;
    private final String writer;



    public String getWriter() {
        return writer;
    }

    public String getQuote() {
        return quote;
    }

    public quoteslist(String quote, String writer) {
        this.quote = quote;
        this.writer = writer;
    }
}

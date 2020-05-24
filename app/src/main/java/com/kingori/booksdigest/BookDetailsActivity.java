package com.kingori.booksdigest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class BookDetailsActivity extends AppCompatActivity {
    private EditText mBookTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        mBookTitle = findViewById(R.id.bookTitle);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        mBookTitle.setText(title);
    }
}
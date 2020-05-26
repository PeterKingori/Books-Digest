package com.kingori.booksdigest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class BookDetailsActivity extends AppCompatActivity {
    private EditText mBookTitle;
    private EditText mAuthor;

    private String[] authors = new String[] {"Wangari Maathai", "John Rothchild", "Paul Kalanithi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        mBookTitle = findViewById(R.id.bookTitle);
        mAuthor= findViewById(R.id.authorEditText);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        mBookTitle.setText(title);

    }
}
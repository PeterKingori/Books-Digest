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
    private EditText mDate;
    private EditText mReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        mBookTitle = findViewById(R.id.bookTitle);
        mAuthor= findViewById(R.id.authorEditText);
        mDate = findViewById(R.id.dateEditText);
        mReview = findViewById(R.id.reviewEditText);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String author = intent.getStringExtra("author");
        String date = intent.getStringExtra("date");
        String review = intent.getStringExtra("review");
        mBookTitle.setText(title);
        mAuthor.setText(author);
        mDate.setText(date);
        mReview.setText(review);
    }
}
package com.kingori.booksdigest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import java.util.Arrays;

public class BookDetailsActivity extends AppCompatActivity {

    private EditText mMBookTitleEditText;
    private EditText mMAuthorEditText;
    private EditText mMDateEditText;
    private EditText mMReviewEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        mMBookTitleEditText = (EditText) findViewById(R.id.bookTitle);
        mMAuthorEditText = (EditText) findViewById(R.id.authorEditText);
        mMDateEditText = (EditText) findViewById(R.id.dateEditText);
        mMReviewEditText = (EditText) findViewById(R.id.reviewEditText);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        mMBookTitleEditText.setText(title);
    }
}

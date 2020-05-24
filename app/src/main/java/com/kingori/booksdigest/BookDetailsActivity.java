package com.kingori.booksdigest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookDetailsActivity extends AppCompatActivity {
    @BindView(R.id.bookTitle) EditText mMBookTitleEditText;
    @BindView(R.id.authorEditText) EditText mMAuthorEditText;
    @BindView(R.id.dateEditText) EditText mMDateEditText;
    @BindView(R.id.reviewEditText) EditText mMReviewEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        mMBookTitleEditText.setText(title);
    }
}

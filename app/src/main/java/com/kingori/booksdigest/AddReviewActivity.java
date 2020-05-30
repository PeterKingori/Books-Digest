package com.kingori.booksdigest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddReviewActivity extends AppCompatActivity {
    @BindView(R.id.titleEditText) EditText mTitle;
    @BindView(R.id.authorEditText) EditText mAuthor;
    @BindView(R.id.dateEditText) EditText mDate;
    @BindView(R.id.reviewEditText) EditText mReview;
    @BindView(R.id.addReview) Button mAddReviewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);
        ButterKnife.bind(this);
        Intent intent = getIntent();

        mAddReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = mTitle.getText().toString();
                String author = mAuthor.getText().toString();
                String date = mDate.getText().toString();
                String review = mReview.getText().toString();
                Intent intent = new Intent(AddReviewActivity.this, MainActivity.class);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });

    }
}
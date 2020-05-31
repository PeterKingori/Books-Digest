package com.kingori.booksdigest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReviewActivity extends AppCompatActivity {
    @BindView(R.id.titleEditText) EditText mTitle;
    @BindView(R.id.authorEditText) EditText mAuthor;
    @BindView(R.id.dateEditText) EditText mDate;
    @BindView(R.id.reviewEditText) EditText mReview;
    @BindView(R.id.addReview) Button mAddReviewButton;

    public static final String CURRENT_INFO = "com.kingori.booksdigest.CURRENT_INFO";
    private ReviewInfo mCurrentReviewDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        ButterKnife.bind(this);

        mAddReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = mTitle.getText().toString();
                String author = mAuthor.getText().toString();
                String date = mDate.getText().toString();
                String review = mReview.getText().toString();
                ReviewInfo newReview = new ReviewInfo(title, author, date, review);
                Intent intent = new Intent(ReviewActivity.this, MainActivity.class);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });

        readDisplayStateValues();
        displayReviewDetails(mTitle, mAuthor, mDate, mReview);

    }

    private void displayReviewDetails(EditText title, EditText author, EditText date, EditText review) {
        title.setText(mCurrentReviewDetails.getTitle());
        author.setText(mCurrentReviewDetails.getAuthor());
        date.setText(mCurrentReviewDetails.getDate());
        review.setText(mCurrentReviewDetails.getReview());
    }

    private void readDisplayStateValues() {
        Intent intent = getIntent();
        mCurrentReviewDetails = intent.getParcelableExtra(CURRENT_INFO);
    }
}
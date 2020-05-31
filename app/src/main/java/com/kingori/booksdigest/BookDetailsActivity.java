package com.kingori.booksdigest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BookDetailsActivity extends AppCompatActivity {
    @BindView(R.id.bookTitle) TextView mBookTitle;
    @BindView(R.id.authorEditText) TextView mAuthor;
    @BindView(R.id.dateEditText) TextView mDate;
    @BindView(R.id.reviewEditText) TextView mReview;
    @BindView(R.id.editReview) Button mEditReviewButton;

    private int mPosition;
    private static ReviewInfo selectedReview = null;
    public static final String REVIEW_POSITION = "com.kingori.booksdigest.REVIEW_POSITION";
    public static final int POSITION_NOT_SET = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        ButterKnife.bind(this);
        Intent intent = getIntent();

        mPosition = intent.getIntExtra(REVIEW_POSITION, POSITION_NOT_SET);
        selectedReview = DataManager.getInstance().getReviews().get(mPosition);

        final String currentTitle = selectedReview.getTitle();
        final String currentAuthor = selectedReview.getAuthor();
        final String currentDate = selectedReview.getDate();
        final String currentReview = selectedReview.getReview();


        mEditReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReviewInfo currentReviewInfo = new ReviewInfo(currentTitle, currentAuthor, currentDate,
                        currentReview);
                Intent intent = new Intent(BookDetailsActivity.this, ReviewActivity.class);
                intent.putExtra(ReviewActivity.CURRENT_INFO, currentReviewInfo);
                startActivity(intent);
            }
        });

        displayReview(mBookTitle, mAuthor, mDate, mReview);

    }

    private void displayReview(TextView mBookTitle, TextView mAuthor,
                               TextView mDate, TextView mReview) {
        mBookTitle.setText(selectedReview.getTitle());
        mAuthor.setText(selectedReview.getAuthor());
        mDate.setText(selectedReview.getDate());
        mReview.setText(selectedReview.getReview());
    }
}
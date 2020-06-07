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
    @BindView(R.id.cancelButton) Button mCancelButton;

    public static final String CURRENT_INFO = "com.kingori.booksdigest.CURRENT_INFO";
    public static final String REVIEW_POSITION = "com.kingori.booksdigest.REVIEW_POSITION";
    private ReviewInfo mCurrentReview;
    private boolean mIsNewReview;
    private int POSITION_NOT_SET = -1;
    private int mReviewPosition;
    private boolean mIsCancelling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        ButterKnife.bind(this);

        readDisplayStateValues();

        if (!mIsNewReview) {
            displayReviewDetails(mTitle, mAuthor, mDate, mReview);
        }

        mAddReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveReview();
                Intent intent = new Intent(ReviewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIsCancelling = true;
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mIsCancelling) {
            if (mIsNewReview) {
                DataManager.getInstance().removeReview(mReviewPosition);
            }
        } else {
            saveReview();
        }
    }

    private void saveReview() {
        mCurrentReview.setTitle(mTitle.getText().toString());
        mCurrentReview.setAuthor(mAuthor.getText().toString());
        mCurrentReview.setDate(mDate.getText().toString());
        mCurrentReview.setReview(mReview.getText().toString());
    }

    private void displayReviewDetails(EditText title, EditText author, EditText date, EditText review) {
        title.setText(mCurrentReview.getTitle());
        author.setText(mCurrentReview.getAuthor());
        date.setText(mCurrentReview.getDate());
        review.setText(mCurrentReview.getReview());
    }

    private void readDisplayStateValues() {
        Intent intent = getIntent();
        int position = intent.getIntExtra(REVIEW_POSITION, POSITION_NOT_SET);
        mIsNewReview = position == POSITION_NOT_SET;
        if (mIsNewReview) {
            createNewReview();
        } else {
            mCurrentReview = (ReviewInfo) DataManager.getInstance().getReviews().get(position);
        }
    }

    private void createNewReview() {
        DataManager dm = DataManager.getInstance();
        mReviewPosition = dm.createNewReview();
        mCurrentReview = dm.getReviews().get(mReviewPosition);
    }


}
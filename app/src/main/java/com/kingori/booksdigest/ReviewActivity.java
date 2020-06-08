package com.kingori.booksdigest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
    private ReviewActivityViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        ButterKnife.bind(this);

        ViewModelProvider viewModelProvider = new ViewModelProvider(getViewModelStore(),
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()));
        mViewModel = viewModelProvider.get(ReviewActivityViewModel.class);

        if (mViewModel.mIsNewlyCreated && savedInstanceState != null) {
            mViewModel.restoreState(savedInstanceState);
        }
        mViewModel.mIsNewlyCreated = false;

        readDisplayStateValues();
        saveOriginalReview();

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

    private void saveOriginalReview() {
         if (mIsNewReview) {
             return;
         }
        mViewModel.mOriginalReviewTitle = mCurrentReview.getTitle();
        mViewModel.mOriginalReviewAuthor = mCurrentReview.getAuthor();
        mViewModel.mOriginalReviewDate = mCurrentReview.getDate();
        mViewModel.mOriginalReviewReview = mCurrentReview.getReview();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mIsCancelling) {
            if (mIsNewReview) {
                DataManager.getInstance().removeReview(mReviewPosition);
            }
            else {
                storePreviousReviewDetails();
            }
        } else {
            saveReview();
        }
    }

    private void storePreviousReviewDetails() {
        mCurrentReview.setTitle(mViewModel.mOriginalReviewTitle);
        mCurrentReview.setAuthor(mViewModel.mOriginalReviewAuthor);
        mCurrentReview.setDate(mViewModel.mOriginalReviewDate);
        mCurrentReview.setReview(mViewModel.mOriginalReviewReview);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it's present
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_share) {
            share();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (outState != null) {
            mViewModel.saveState(outState);
        }
    }

    private void share() {
        String bookTitle = mTitle.getText().toString();
        String bookAuthor = mAuthor.getText().toString();
        String bookReview = mReview.getText().toString();
        String text = "Check out my review for this book: \n" + bookTitle + "\nBy: " + bookAuthor
                +"\n" + bookReview;
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, bookTitle);
        intent.putExtra(Intent.EXTRA_TEXT, text);

        Intent shareIntent = Intent.createChooser(intent, null);
        startActivity(shareIntent);
    }

}
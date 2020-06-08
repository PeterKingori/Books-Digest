package com.kingori.booksdigest;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;

public class ReviewActivityViewModel extends ViewModel {
    public static final String ORIGINAL_REVIEW_TITLE = "com.kingori.booksdigest.ORIGINAL_REVIEW_TITLE";
    public static final String ORIGINAL_REVIEW_AUTHOR = "com.kingori.booksdigest.ORIGINAL_REVIEW_AUTHOR";
    public static final String ORIGINAL_REVIEW_DATE = "com.kingori.booksdigest.ORIGINAL_REVIEW_DATE";
    public static final String ORIGINAL_REVIEW_REVIEW = "com.kingori.booksdigest.ORIGINAL_REVIEW_REVIEW";

    public String mOriginalReviewTitle;
    public String mOriginalReviewAuthor;
    public String mOriginalReviewDate;
    public String mOriginalReviewReview;
    public boolean mIsNewlyCreated = true;

    public void saveState(Bundle outState) {
        outState.putString(ORIGINAL_REVIEW_TITLE, mOriginalReviewTitle);
        outState.putString(ORIGINAL_REVIEW_AUTHOR, mOriginalReviewAuthor);
        outState.putString(ORIGINAL_REVIEW_DATE, mOriginalReviewDate);
        outState.putString(ORIGINAL_REVIEW_REVIEW, mOriginalReviewReview);
    }

    public void restoreState(Bundle inState) {
        mOriginalReviewTitle = inState.getString(ORIGINAL_REVIEW_TITLE);
        mOriginalReviewAuthor = inState.getString(ORIGINAL_REVIEW_AUTHOR);
        mOriginalReviewDate = inState.getString(ORIGINAL_REVIEW_DATE);
        mOriginalReviewReview = inState.getString(ORIGINAL_REVIEW_REVIEW);
    }
}

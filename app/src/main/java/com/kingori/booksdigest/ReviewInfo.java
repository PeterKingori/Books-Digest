package com.kingori.booksdigest;

import androidx.annotation.NonNull;

public class ReviewInfo {
    private String mTitle;
    private String mAuthor;
    private String mDate;
    private String mReview;

    public ReviewInfo(String title, String author, String date, String review) {
        this.mTitle = title;
        this.mAuthor = author;
        this.mDate = date;
        this.mReview = review;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getDate() {
        return mDate;
    }

    public String getReview() {
        return mReview;
    }

    @Override
    public String toString() {
        return mTitle;
    }
}

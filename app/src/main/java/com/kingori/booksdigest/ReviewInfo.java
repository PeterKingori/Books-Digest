package com.kingori.booksdigest;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;


public class ReviewInfo implements Parcelable {
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

    private ReviewInfo(Parcel parcel) {
        mTitle = parcel.readString();
        mAuthor = parcel.readString();
        mDate = parcel.readString();
        mReview = parcel.readString();
    }

    public String getTitle() { return mTitle; }

    public String getAuthor() {
        return mAuthor;
    }

    public String getDate() { return mDate; }

    public String getReview() {
        return mReview;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public void setAuthor(String author) {
        this.mAuthor = author;
    }

    public void setDate(String date) {
        this.mDate = date;
    }

    public void setReview(String review) {
        this.mReview = review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewInfo that = (ReviewInfo) o;
        return mTitle.equals(that.mTitle) &&
                mAuthor.equals(that.mAuthor) &&
                mDate.equals(that.mDate) &&
                mReview.equals(that.mReview);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mTitle, mAuthor, mDate, mReview);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mTitle);
        parcel.writeString(mAuthor);
        parcel.writeString(mDate);
        parcel.writeString(mReview);
    }

    public static final Parcelable.Creator<ReviewInfo> CREATOR =
            new Parcelable.Creator<ReviewInfo>() {

                @Override
                public ReviewInfo createFromParcel(Parcel parcel) {
                    return new ReviewInfo(parcel);
                }

                @Override
                public ReviewInfo[] newArray(int size) {
                    return new ReviewInfo[size];
                }
            };
}

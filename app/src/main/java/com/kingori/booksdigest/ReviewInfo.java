package com.kingori.booksdigest;

import android.os.Parcel;
import android.os.Parcelable;


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

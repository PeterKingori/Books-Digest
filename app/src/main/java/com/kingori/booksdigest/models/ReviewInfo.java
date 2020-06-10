package com.kingori.booksdigest.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;


public class ReviewInfo implements Parcelable {
    private String title;
    private String author;
    private String date;
    private String review;

    public ReviewInfo() {}

    public ReviewInfo(String title, String author, String date, String review) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.review = review;
    }

    private ReviewInfo(Parcel parcel) {
        title = parcel.readString();
        author = parcel.readString();
        date = parcel.readString();
        review = parcel.readString();
    }

    public String getTitle() { return title; }

    public String getAuthor() {
        return author;
    }

    public String getDate() { return date; }

    public String getReview() {
        return review;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewInfo that = (ReviewInfo) o;
        return title.equals(that.title) &&
                author.equals(that.author) &&
                date.equals(that.date) &&
                review.equals(that.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, date, review);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(author);
        parcel.writeString(date);
        parcel.writeString(review);
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

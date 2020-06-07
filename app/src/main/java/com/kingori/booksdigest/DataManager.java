package com.kingori.booksdigest;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager ourInstance = null;

    private List<ReviewInfo> mReviews = new ArrayList<>();
    private List<String> mTitles = new ArrayList<>();

    public static DataManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new DataManager();
            ourInstance.initializeTitles();
            ourInstance.initializeReviews();
        }
        return ourInstance;
    }

    public int createNewReview() {
        ReviewInfo review = new ReviewInfo(null, null, null, null);
        mReviews.add(review);
        return mReviews.size() - 1;
    }

    public List<String> getTitles() {
        return mTitles;
    }

    public List<ReviewInfo> getReviews() {
        return mReviews;
    }

    public void removeReview(int index) {
        mReviews.remove(index);
    }


    //Initialization code
    private void initializeTitles() {
        mTitles.add("Unbowed");
        mTitles.add("The Davis Dynasty");
        mTitles.add("When Breath Becomes Air");
    }

    private void initializeReviews() {
        mReviews.add(initializeReview1());
        mReviews.add(initializeReview2());
        mReviews.add(initializeReview3());
    }

    private ReviewInfo initializeReview1() {
        return new ReviewInfo("Unbowed", "Wangari Maathai", "January 10, 2018",
                "Unbowed, a straightforward and unfussy memoir, is most " +
            "moving when it details the challenges this outspoken, accomplished, passionate woman faced " +
            "in a Kenya that had no tolerance for anything other than quiet girls, " +
            "quiet matrons, and quiet grandmothers.");
    }

    private ReviewInfo initializeReview2() {
        return new ReviewInfo("The Davis Dynasty", "John Rothchild", "May 4, 2019",
                "Provides a good historical overview of the investing " +
            "landscape throughout the 20th century while focusing on the disciplined approach to investing " +
            "followed by the Davis family, which allowed them to build their wealth throughout the ups " +
            "and downs of the markets.");
    }

    private ReviewInfo initializeReview3() {
        return new ReviewInfo("When Breath Becomes Air", "Paul Kalanithi", "November 25, 2019",
                "An emotional investment well worth making: a moving and " +
            "thoughtful memoir of family, medicine and literature. It is, despite its grim undertone, " +
            "accidentally inspiring.");
    }


}

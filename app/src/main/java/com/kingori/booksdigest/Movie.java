package com.kingori.booksdigest;

public class Movie {
    private String mMovieTitle;
    private String mOverview;
    private String mReleaseDate;

    public Movie(String movieTitle, String overview, String releaseDate) {
        mMovieTitle = movieTitle;
        mOverview = overview;
        mReleaseDate = releaseDate;
    }

    public String getMovieTitle() {
        return mMovieTitle;
    }

    public String getOverview() {
        return mOverview;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }
}

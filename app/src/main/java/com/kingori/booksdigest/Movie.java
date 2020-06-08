package com.kingori.booksdigest;

public class Movie {
    private String movieTitle;
    private String overview;
    private String releaseDate;

    public Movie(String movieTitle, String overview, String releaseDate) {
        movieTitle = movieTitle;
        overview = overview;
        releaseDate = releaseDate;
    }

    public Movie() {}

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}

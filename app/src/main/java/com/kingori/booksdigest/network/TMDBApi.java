package com.kingori.booksdigest.network;

import com.kingori.booksdigest.models.MovieDatabaseSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface TMDBApi {
    @GET("search/movie?")
    Call<MovieDatabaseSearchResponse> getMovies(
            @Query("query") String mBookTitle,
            @Query("api_key") String THEMOVIEDB_API_KEY
    );
}

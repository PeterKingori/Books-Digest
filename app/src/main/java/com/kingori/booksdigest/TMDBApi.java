package com.kingori.booksdigest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import static com.kingori.booksdigest.Constants.THEMOVIEDB_API_KEY;


public interface TMDBApi {
    @GET("search/movie?")
    Call<MovieDatabaseSearchResponse> getMovies(
            @Query("query") String mBookTitle,
            @Query("api_key") String THEMOVIEDB_API_KEY
    );
}

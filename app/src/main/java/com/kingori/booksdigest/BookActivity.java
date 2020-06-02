package com.kingori.booksdigest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.kingori.booksdigest.Constants.THEMOVIEDB_API_KEY;

public class BookActivity extends AppCompatActivity {
    public static final String TAG = BookActivity.class.getSimpleName();
    private Button mFindMovieButton;
    private EditText mFindBookEdit;
    private TextView mMovieTextView;
    private String mBookTitle;
    private ListView mMovieListView;
    public List<Result> moviesList;
    private String[] movies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        mFindBookEdit = findViewById(R.id.findBookEdit);
        mFindMovieButton = findViewById(R.id.findMovie2);
        mMovieTextView = findViewById(R.id.movieTextView);
        mMovieListView = findViewById(R.id.movieListView);

        mFindMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBookTitle = mFindBookEdit.getText().toString();
                mMovieTextView.setText("Here are all the movies related to the book title " + mBookTitle);
                showMovies();
            }
        });
    }

    private void showMovies() {
        TMDBApi client = TMDBClient.getClient();
        Call<MovieDatabaseSearchResponse> call = client.getMovies(mBookTitle, THEMOVIEDB_API_KEY);
        call.enqueue(new Callback<MovieDatabaseSearchResponse>() {
            @Override
            public void onResponse(Call<MovieDatabaseSearchResponse> call, Response<MovieDatabaseSearchResponse> response) {
                if (response.isSuccessful()) {
                    moviesList = response.body().getResults();
                    movies = new String[moviesList.size()];
                    for (int i = 0; i < movies.length; i++) {
                        movies[i] = moviesList.get(i).getTitle();
                    }

                    ArrayAdapter moviesAdapter = new ArrayAdapter(BookActivity.this, android.R.layout.simple_list_item_1, movies);
                    mMovieListView.setAdapter(moviesAdapter);
                }
            }

            @Override
            public void onFailure(Call<MovieDatabaseSearchResponse> call, Throwable t) {

            }
        });

    }


}
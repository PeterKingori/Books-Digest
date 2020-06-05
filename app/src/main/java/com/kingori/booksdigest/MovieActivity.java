package com.kingori.booksdigest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.kingori.booksdigest.Constants.THEMOVIEDB_API_KEY;

public class MovieActivity extends AppCompatActivity {
    public static final String TAG = MovieActivity.class.getSimpleName();
    private String mBookTitle;
    public List<Result> moviesList;
    private MovieListAdapter mAdapter;

    @BindView(R.id.findBookEdit) EditText mFindBookEdit;
    @BindView(R.id.findMovieButton) Button mFindMovieButton;
    @BindView(R.id.movieTextView) TextView mMovieTextView;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);

        mFindMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBookTitle = mFindBookEdit.getText().toString();
                mMovieTextView.setText(String.format("Here are all the movies related to the book title: %s", mBookTitle));

                TMDBApi client = TMDBClient.getClient();
                Call<MovieDatabaseSearchResponse> call = client.getMovies(mBookTitle, THEMOVIEDB_API_KEY);
                call.enqueue(new Callback<MovieDatabaseSearchResponse>() {
                    @Override
                    public void onResponse(@NotNull Call<MovieDatabaseSearchResponse> call, @NotNull Response<MovieDatabaseSearchResponse> response) {
                        if (response.isSuccessful()) {
                            Log.d(TAG, "Response is successful " + response);
                            if (response.body() != null) {
                                moviesList = response.body().getResults();
                            }
                            mAdapter = new MovieListAdapter(MovieActivity.this, moviesList);
                            mRecyclerView.setAdapter(mAdapter);
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MovieActivity.this);
                            mRecyclerView.setLayoutManager(layoutManager);
                            mRecyclerView.setHasFixedSize(true);
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<MovieDatabaseSearchResponse> call, @NotNull Throwable t) {
                        Log.e(TAG, "No movies response", t);
                    }
                });
            }
        });
    }

}
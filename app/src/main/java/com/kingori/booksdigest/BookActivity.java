package com.kingori.booksdigest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class BookActivity extends AppCompatActivity {
    public static final String TAG = BookActivity.class.getSimpleName();
    private Button mFindMovieButton;
    private EditText mFindBookEdit;
    private TextView mMovieTextView;
    private String mBookTitle;
    private ListView mMovieListView;
    private String[] movies = new String[] {"Invictus", "Remember the Titans", "Titanic", "The Lake House"};


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
        ArrayAdapter moviesAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, movies);
        mMovieListView.setAdapter(moviesAdapter);
    }
}
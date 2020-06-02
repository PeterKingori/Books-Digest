package com.kingori.booksdigest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BookActivity extends AppCompatActivity {
    public static final String TAG = BookActivity.class.getSimpleName();
    private Button mFindMovieButton;
    private EditText mFindBookEdit;
    private String mBook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        mFindBookEdit = findViewById(R.id.findBookEdit);
        mFindMovieButton = findViewById(R.id.findMovie2);

        mFindMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBook = mFindBookEdit.getText().toString();
            }
        });

    }
}
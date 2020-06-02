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
    private Button mFindBookButton;
    private EditText mFindBookEdit;
    private TextView mTitleTextView;
    private String mBook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        mFindBookEdit = findViewById(R.id.findBookEdit);
        mFindBookButton = findViewById(R.id.findBookButton);
        mTitleTextView = findViewById(R.id.titleTextView);

        mFindBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBook = mFindBookEdit.getText().toString();
                mTitleTextView.setText(mBook);
            }
        });

    }
}
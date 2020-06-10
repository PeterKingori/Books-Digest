package com.kingori.booksdigest.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.kingori.booksdigest.DataManager;
import com.kingori.booksdigest.R;
import com.kingori.booksdigest.adapters.ReviewListAdapter;
import com.kingori.booksdigest.models.ReviewInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.newReview) Button mNewReviewButton;
    @BindView(R.id.findMovie1) Button mFindMovie;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private ReviewListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mNewReviewButton.setOnClickListener(this);
        mFindMovie.setOnClickListener(this);

        initializeDisplayContent();
    }

    private void initializeDisplayContent() {
        List<ReviewInfo> reviews = DataManager.getInstance().getReviews();
        Log.e(" Review: ", String.valueOf(reviews));
        mAdapter = new ReviewListAdapter(MainActivity.this, reviews);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
    }

    @Override
    public void onClick(View view) {
        if (view == mNewReviewButton) {
            startActivity(new Intent(MainActivity.this, ReviewActivity.class));
        }
        if (view == mFindMovie) {
            startActivity(new Intent(MainActivity.this, MovieActivity.class));
        }
    }
}
package com.kingori.booksdigest.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kingori.booksdigest.Constants;
import com.kingori.booksdigest.R;
import com.kingori.booksdigest.models.ReviewInfo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.reviewList) ListView mListTitles;
    @BindView(R.id.newReview) Button mNewReviewButton;
    @BindView(R.id.findMovie1) Button mFindMovie;
    private ArrayAdapter<ReviewInfo> mAdapterTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mNewReviewButton.setOnClickListener(this);
        mFindMovie.setOnClickListener(this);

        initializeDisplayContent();
    }

    /*@Override
    protected void onResume() {
        super.onResume();
        mAdapterTitles.notifyDataSetChanged();
    } */

    private void initializeDisplayContent() {
        final ArrayList<ReviewInfo> reviews = new ArrayList<>();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_REVIEWS);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.e("Count: " ,"" + dataSnapshot.getChildrenCount());
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    reviews.add(snapshot.getValue(ReviewInfo.class));
                }
                mAdapterTitles = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, reviews);
                mListTitles.setAdapter(mAdapterTitles);
                mListTitles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        String title = ((TextView)view).getText().toString();
                        Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, BookDetailsActivity.class);
                        intent.putExtra(BookDetailsActivity.REVIEW_POSITION, position);
                        startActivity(intent);
                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
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


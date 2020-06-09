package com.kingori.booksdigest.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kingori.booksdigest.Constants;
import com.kingori.booksdigest.DataManager;
import com.kingori.booksdigest.R;
import com.kingori.booksdigest.models.ReviewInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BookDetailsActivity extends AppCompatActivity {
    @BindView(R.id.bookTitle) TextView mBookTitle;
    @BindView(R.id.authorEditText) TextView mAuthor;
    @BindView(R.id.dateEditText) TextView mDate;
    @BindView(R.id.reviewEditText) TextView mReview;
    @BindView(R.id.editReview) Button mEditReviewButton;

    private static ReviewInfo selectedReview;
    public static final String REVIEW_POSITION = "com.kingori.booksdigest.REVIEW_POSITION";
    public static final int POSITION_NOT_SET = -1;
    private static List<ReviewInfo> mReviews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        ButterKnife.bind(this);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_CHILD_REVIEWS);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.e("Count: " ,"" + dataSnapshot.getChildrenCount());
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    mReviews.add(snapshot.getValue(ReviewInfo.class));
                    Log.e("Reviews: ", String.valueOf(mReviews));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("The read failed: ", databaseError.getMessage());
            }
        });

        Intent intent = getIntent();
        final int position = intent.getIntExtra(REVIEW_POSITION, POSITION_NOT_SET);
        selectedReview = DataManager.getInstance().getReviews().get(position);

        mEditReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookDetailsActivity.this, ReviewActivity.class);
                intent.putExtra(ReviewActivity.REVIEW_POSITION, position);
                startActivity(intent);
            }
        });

        displayReview(mBookTitle, mAuthor, mDate, mReview);

    }

    private void displayReview(TextView mBookTitle, TextView mAuthor,
                               TextView mDate, TextView mReview) {
        mBookTitle.setText(selectedReview.getTitle());
        mAuthor.setText(selectedReview.getAuthor());
        mDate.setText(selectedReview.getDate());
        mReview.setText(selectedReview.getReview());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it's present
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_share) {
            share();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void share() {
        String bookTitle = mBookTitle.getText().toString();
        String bookAuthor = mAuthor.getText().toString();
        String bookReview = mReview.getText().toString();
        String text = "Check out my review for this book: \n" + bookTitle + "\nBy: " + bookAuthor
                +"\n" + bookReview;
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, bookTitle);
        intent.putExtra(Intent.EXTRA_TEXT, text);

        Intent shareIntent = Intent.createChooser(intent, null);
        startActivity(shareIntent);
    }
}
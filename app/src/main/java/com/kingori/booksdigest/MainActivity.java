package com.kingori.booksdigest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.reviewList) ListView mListTitles;
    @BindView(R.id.newReview) Button mNewReviewButton;
    @BindView(R.id.findReview) Button mFindReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mNewReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ReviewActivity.class));
            }
        });

        mFindReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BookActivity.class));
            }
        });

        initializeDisplayContent();
    }

    private void initializeDisplayContent() {
        List<String> titles = DataManager.getInstance().getTitles();
        ArrayAdapter<String> adapterTitles = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles);
        mListTitles.setAdapter(adapterTitles);

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

}


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initializeDisplayContent();
    }

    private void initializeDisplayContent() {
        List<String> titles = DataManager.getInstance().getTitles();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, titles);
        mListTitles.setAdapter(adapter);

        mListTitles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String title = ((TextView)view).getText().toString();
                Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, BookDetailsActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }


}


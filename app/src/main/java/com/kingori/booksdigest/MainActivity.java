package com.kingori.booksdigest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.reviewList) ListView mListView;

    private String[] titles = new String[] {"Unbowed", "The Davis Dynasty", "When Breath Becomes Air"};
    private String[] authors = new String[] {"Wangari Maathai", "John Rothchild", "Paul Kalanithi"};
    private String[] dates = new String[] {"January 10, 2018", "May 4, 2019", "November 25, 2019"};
    private String[] reviews = new String[] {"Unbowed, a straightforward and unfussy memoir, is most " +
            "moving when it details the challenges this outspoken, accomplished, passionate woman faced " +
            "in a Kenya that had no tolerance for anything other than quiet girls, " +
            "quiet matrons, and quiet grandmothers.", "Provides a good historical overview of the investing " +
            "landscape throughout the 20th century while focusing on the disciplined approach to investing " +
            "followed by the Davis family, which allowed them to build their wealth throughout the ups " +
            "and downs of the markets.", "An emotional investment well worth making: a moving and " +
            "thoughtful memoir of family, medicine and literature. It is, despite its grim undertone, " +
            "accidentally inspiring."};
    private String[] favquotes = new String[] {"What people see as fearlessness is really persistence.",
            "Bear markets make people a lot of money, they just don’t know it at the time.",
            "You can't ever reach perfection, but you can believe in an asymptote toward which " +
                    "you are ceaselessly striving."};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, titles);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String title = ((TextView)view).getText().toString();
                Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

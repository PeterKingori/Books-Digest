package com.kingori.booksdigest.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

public class BooksArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mTitles;
    private String[] mAuthors;

    public BooksArrayAdapter(Context mContext, int resource, String[] mTitles, String[] mAuthors) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mTitles = mTitles;
        this.mAuthors = mAuthors;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        String title = mTitles[position];
        String author = mAuthors[position];
        return String.format("%s \n By: %s", title, author);
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }
}

package com.kingori.booksdigest;

import android.content.Context;
import android.widget.ArrayAdapter;

public class BooksArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mTitles;
    private String[] mDescriptions;
    private String[] mReleaseDates;

    public BooksArrayAdapter(Context context, int resource, String[] titles, String[] descriptions, String[] releaseDates) {
        super(context, resource);
        this.mContext = context;
        this.mTitles = titles;
        this.mDescriptions = descriptions;
        this.mReleaseDates = releaseDates;
    }
    @Override
    public Object getItem(int position) {
        String title = mTitles[position];
        String description = mDescriptions[position];
        String releaseDate = mReleaseDates[position];
        return String.format("%s \n Description: %s \n Release Date: %s", title, description, releaseDate);
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }
}

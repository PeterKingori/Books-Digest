package com.kingori.booksdigest;

import android.content.Context;
import android.widget.ArrayAdapter;

public class BooksArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mTitles;

    public BooksArrayAdapter(Context context, int resource, String[] titles) {
        super(context, resource);
        this.mContext = context;
        this.mTitles = titles;
    }
    @Override
    public Object getItem(int position) {
        String title = mTitles[position];
        return String.format("%s", title);
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }
}

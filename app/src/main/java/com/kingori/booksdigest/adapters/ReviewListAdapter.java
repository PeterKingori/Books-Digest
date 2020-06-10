package com.kingori.booksdigest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kingori.booksdigest.R;
import com.kingori.booksdigest.models.ReviewInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReviewListAdapter extends RecyclerView.Adapter<ReviewListAdapter.ReviewViewHolder> {
    private List<ReviewInfo> mReviews;
    private Context mContext;

    public ReviewListAdapter(Context context, List<ReviewInfo> reviews) {
        mContext = context;
        mReviews = reviews;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_item, parent, false);
        ReviewViewHolder viewHolder = new ReviewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewListAdapter.ReviewViewHolder holder, int position) {
        holder.bindReview(mReviews.get(position));
    }

    @Override
    public int getItemCount() {
        return mReviews.size();
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.bookTitle) TextView mBookTitle;
        @BindView(R.id.bookAuthor) TextView mBookAuthor;

        private Context mContext;

        public ReviewViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindReview(ReviewInfo review) {
            mBookTitle.setText(review.getTitle());
            mBookAuthor.setText(String.format("By: %s", review.getAuthor()));
        }
    }
}

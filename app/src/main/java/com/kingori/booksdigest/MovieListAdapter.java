package com.kingori.booksdigest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    private List<Result> mMovies;

    public MovieListAdapter(Context context, List<Result> movies) {
        mMovies = movies;
    }

    @NotNull
    @Override
    public MovieListAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieListAdapter.MovieViewHolder holder, int position) {
        holder.bindMovie(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.movieTitleTextView) TextView mMovieTitleTextView;
        @BindView(R.id.movieDescriptionTextView) TextView mMovieDescriptionTextView;
        @BindView(R.id.movieReleaseDate) TextView mMovieReleaseDate;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            Context context = itemView.getContext();
        }

        public void bindMovie(Result movie) {
            mMovieTitleTextView.setText(movie.getTitle());
            mMovieDescriptionTextView.setText(movie.getOverview());
            mMovieReleaseDate.setText(movie.getReleaseDate());
        }
    }

}

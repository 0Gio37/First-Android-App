package com.georges.android.firstapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.georges.android.firstapplication.R;
import com.georges.android.firstapplication.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    public Context mContext;
    public ArrayList<Movie> mMovies;

    public SearchAdapter(Context mContext, ArrayList<Movie> mMovies){
        this.mContext = mContext;
        this.mMovies = mMovies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_search_movie,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = mMovies.get(position);
        holder.mTextViewSingleMovieTitle.setText(movie.getTitle());
        holder.mTextViewSingleMovieDate.setText(movie.getReleased());
        Picasso.get().load(movie.getPoster()).into(holder.mImageViewSingleMoviePoster);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextViewSingleMovieTitle;
        public TextView mTextViewSingleMovieDate;
        public ImageView mImageViewSingleMoviePoster;

        public ViewHolder(View view) {
            super(view);
            mTextViewSingleMovieTitle = (TextView) view.findViewById(R.id.text_view_first_single_item);
            mTextViewSingleMovieDate = (TextView) view.findViewById(R.id.text_view_second_single_item);
            mImageViewSingleMoviePoster = (ImageView) view.findViewById(R.id.image_view_single_item);
        }



    }
}

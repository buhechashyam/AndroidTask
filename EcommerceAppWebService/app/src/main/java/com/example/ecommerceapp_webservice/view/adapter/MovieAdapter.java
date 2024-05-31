package com.example.ecommerceapp_webservice.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp_webservice.R;
import com.example.ecommerceapp_webservice.model.MovieModel;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    ArrayList<MovieModel> mMovieList;
    Context mContext;

    public MovieAdapter(ArrayList<MovieModel> mMovieList, Context mContext) {
        this.mMovieList = mMovieList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_movie,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        MovieModel movieModel = mMovieList.get(position);
        holder.mTextViewTitle.setText(movieModel.getTitle());
        holder.mTextViewDesc.setText(movieModel.getDirector());
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        TextView mTextViewTitle;
        TextView mTextViewDesc;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
             mTextViewTitle = itemView.findViewById(R.id.text_title);
             mTextViewDesc = itemView.findViewById(R.id.text_desc);
        }
    }
}

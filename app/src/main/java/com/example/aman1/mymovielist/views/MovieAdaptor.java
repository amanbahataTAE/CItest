package com.example.aman1.mymovielist.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aman1.mymovielist.R;
import com.example.aman1.mymovielist.model.Result_;
import com.example.aman1.mymovielist.util.constants.API_LIST;
import com.squareup.picasso.Picasso;


import java.util.List;

/**
 * Created by aman1 on 23/11/2017.
 */

public class MovieAdaptor extends RecyclerView.Adapter<MovieAdaptor.MyViewHolder> {


    private List<Result_> moviesList;
    private int row_movies;
    private Context applicationContext;

    public MovieAdaptor(List<Result_> moviesList, int row_movies, Context applicationContext) {
        this.moviesList = moviesList;
        this.row_movies = row_movies;
        this.applicationContext = applicationContext;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.applicationContext).inflate(row_movies, parent, false);
        return new MyViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.movieId.setText(moviesList.get(position).getId().toString());
        holder.movieTitle.setText(moviesList.get(position).getTitle());
        holder.moviePopularity.setText(moviesList.get(position).getPopularity().toString());

        //Adds the picasso library to retrieve the image, resize it and load it

        Picasso.with(applicationContext)
                .load(API_LIST.BASE_URL_PICTURES + "" + moviesList.get(position).getPosterPath())
                .resize(200, 200)
                .centerCrop()
                .into(holder.moviePhoto);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView movieId, movieTitle, moviePopularity;
        ImageView moviePhoto;

        public MyViewHolder(View itemView) {
            super(itemView);

            movieId = (TextView) itemView.findViewById(R.id.movie_id);
            movieTitle = (TextView) itemView.findViewById(R.id.movie_title);
            moviePopularity = (TextView) itemView.findViewById(R.id.movie_popularity);
            moviePhoto = (ImageView) itemView.findViewById(R.id.movie_poster);


        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), movieId.getId() + " Clicked", Toast.LENGTH_LONG).show();
        }
    }
}

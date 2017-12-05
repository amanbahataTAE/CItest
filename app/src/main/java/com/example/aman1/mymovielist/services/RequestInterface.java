package com.example.aman1.mymovielist.services;

import com.example.aman1.mymovielist.model.Result;
import com.example.aman1.mymovielist.model.moviedetail.MovieDetail;
import com.example.aman1.mymovielist.util.constants.API_LIST;



import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by aman1 on 23/11/2017.
 */

public interface RequestInterface {


    @GET(API_LIST.API_TOP_RATED_MOVIE_LIST)
    Observable<Result> getMovies(@Query("api_key") String apiKey);



    @GET(API_LIST.API_TOP_RATED_MOVIE_DETAIL)
    Observable<MovieDetail> getMovieDetail(@Path("id") int id, @Query("api_key") String apikey);

}
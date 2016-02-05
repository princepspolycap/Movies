package com.example.polycap.movies.model;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Polycap on 9/4/2015.
 */
public interface MovieAPIs {


    @GET("/movie/popular")
    Observable<MovieModel> getMovieResults(@Query("api_key")String key);


}

package com.example.polycap.movies.model;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Polycap on 9/7/2015.
 */
public interface TvShowsAPIs {
    @GET("/tv/top_rated")
    Observable<TvShowModel> getTvShowsResults(@Query("api_key") String key);
}

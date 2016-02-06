package com.example.polycap.movies.model;

import com.example.polycap.movies.R;
import com.example.polycap.movies.model.MovieDetailsModel;
import com.example.polycap.movies.view.EntertainmentApp;

import rx.Observable;

import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Polycap on 2/5/2016.
 */
public class MovieDetailsClient {

    EntertainmentApp getMContext;
    private MovieDApi movieDApi;


    public MovieDetailsClient(EntertainmentApp Mcontext){
        this.getMContext = Mcontext;


        RestAdapter restMAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(EntertainmentApp.getContext().getString(R.string.Entertainment_DB))
                .build();
        movieDApi = restMAdapter.create(MovieDApi.class);
    }

    public Observable<MovieDetailsModel> getMovieDResults(String id){
        return movieDApi.getMoveiDetails(id, EntertainmentApp.getContext().getString(R.string.apikey));
    }

    public interface MovieDApi{
        @GET("/movie/{id}")
        Observable<MovieDetailsModel> getMoveiDetails(
                @Path("id") String mId,
                @Query("api_key") String key);

    }


}

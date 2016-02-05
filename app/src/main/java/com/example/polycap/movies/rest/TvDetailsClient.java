package com.example.polycap.movies.rest;

import com.example.polycap.movies.R;
import com.example.polycap.movies.model.MovieModel;
import com.example.polycap.movies.rest.models.TvDetailsModel;
import com.example.polycap.movies.view.EntertainmentApp;

import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Polycap on 11/9/2015.
 */
public class TvDetailsClient {
    EntertainmentApp context;
    private TvAPI tDetailsAPI;

    public TvDetailsClient(EntertainmentApp tContext) {
        this.context = tContext;

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(EntertainmentApp.getContext().getString(R.string.Entertainment_DB))
                .build();
        tDetailsAPI = restAdapter.create(TvAPI.class);
    }

    public Observable<TvDetailsModel> getTvResults(String tVshowId) {
        return tDetailsAPI.getTvDetails(tVshowId, EntertainmentApp.getContext().getString(R.string.apikey));
    }

    public interface TvAPI {
        @GET("/tv/{id}")
        Observable<TvDetailsModel> getTvDetails(
                @Path("id") String tvId,
                @Query("api_key") String key);

        @GET("/tv/top_rated")
        Observable<MovieModel> getTvshowDetails(
                @Query("api_key") String key);
    }

}

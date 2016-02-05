package com.example.polycap.movies.model;

import com.example.polycap.movies.R;
import com.example.polycap.movies.view.EntertainmentApp;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;
import rx.Observable;

/**
 * Created by Polycap on 9/8/2015.
 */
public class TvShowModel {

    @Expose
    private Integer page;
    @Expose
    @SerializedName("results")
    private List<TvShowsResult> tvShowsResults = new ArrayList<TvShowsResult>();
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;

    /**
     * @return The page
     */
    public Integer getPage() {
        return page;
    }

    /**
     * @param page The page
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * @return The tvShowsResults
     */
    public List<TvShowsResult> getTvShowsResults() {
        return tvShowsResults;
    }


    /**
     * @param tvShowsResults The tvShowsResults
     */
    public void setTvShowsResults(List<TvShowsResult> tvShowsResults) {
        this.tvShowsResults = tvShowsResults;
    }

    /**
     * @return The totalPages
     */
    public Integer getTotalPages() {
        return totalPages;
    }

    /**
     * @param totalPages The total_pages
     */
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * @return The totalResults
     */
    public Integer getTotalResults() {
        return totalResults;
    }

    /**
     * @param totalResults The total_results
     */
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }


    public Observable<TvShowModel> getTvShowsDataFromServer() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(EntertainmentApp.getContext().getString(R.string.Entertainment_DB))
                .build();
        TvShowsAPIs tvShowsAPIs = restAdapter.create(TvShowsAPIs.class);
        return tvShowsAPIs.getTvShowsResults(EntertainmentApp.getContext().getString(R.string.apikey));
    }

}


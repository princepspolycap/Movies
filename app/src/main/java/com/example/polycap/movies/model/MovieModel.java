package com.example.polycap.movies.model;

import com.example.polycap.movies.R;
import com.example.polycap.movies.view.EntertainmentApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.RestAdapter;
import rx.Observable;

/**
 * Created by Polycap on 9/4/2015.
 */
public class MovieModel {
    private Integer page;
    private List<MovieResult> results = new ArrayList<>();
    private Integer totalPages;
    private Integer totalResults;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     * @return The results
     */
    public List<MovieResult> getResults() {
        return results;
    }

    /**
     * @param results The results
     */
    public void setResults(List<MovieResult> results) {
        this.results = results;
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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Observable<MovieModel> getMovieDatafromServer() {
        RestAdapter adapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(EntertainmentApp.getContext().getString(R.string.Entertainment_DB))
                .build();
        MovieAPIs movieAPIs = adapter.create(MovieAPIs.class);
        return movieAPIs.getMovieResults(EntertainmentApp.getContext().getString(R.string.apikey));


    }


}

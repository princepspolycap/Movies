package com.example.polycap.movies.view.Activity;

import com.example.polycap.movies.model.MovieDetailsModel;
import com.example.polycap.movies.model.VideoItem;

import java.util.List;

/**
 * Created by Polycap on 2/6/2016.
 */
public interface MovieDetailsI {
    void displayMovieData ( MovieDetailsModel movieDetailsModel);
    void getYoutubeData(List<VideoItem> youtubeVideos);

}

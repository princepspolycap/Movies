package com.example.polycap.movies.view.Activity;

import com.example.polycap.movies.model.TvDetailsModel;
import com.example.polycap.movies.model.VideoItem;

import java.util.List;

/**
 * Created by Polycap on 11/9/2015.
 */
public interface TvDetails {
    void displayData(TvDetailsModel tvShowModel);
    void youtubeVideos (List<VideoItem> videoItems);
}

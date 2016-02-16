package com.example.polycap.movies.model;

import android.content.Context;
import android.util.Log;

import com.example.polycap.movies.R;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 186 on 2/15/2016.
 */
public class YoutubeConnector {
    private static final String TAG = YoutubeConnector.class.getSimpleName();
    private YouTube youtube;
    private YouTube.Search.List query;

    public static final String KEY = "AIzaSyCPVf0fpH1h4Ti3VrwtB78AbgsELV7MfTg";


    public YoutubeConnector(Context context) {
        youtube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(), httpRequest -> {
        }).setApplicationName(context.getString(R.string.app_name)).build();

        try {
            query = youtube.search().list("id,snippet");
            query.setKey(KEY);
            query.setType("video");
            query.setMaxResults(10L);
            query.setFields("items(id/videoId,snippet/title,snippet/description,snippet/thumbnails/high/url)");

            Log.d(TAG, "YoutubeConnector:" + query.toString());
        } catch (IOException e) {
            Log.d("YC", "Could not initialize: " + e.getMessage());
        }
    }


    public List<VideoItem> search(String keywords){
        query.setQ(keywords);

        try {
            SearchListResponse response = query.execute();
            List<SearchResult> results = response.getItems();
            List<VideoItem> items = new ArrayList<>();

            for (SearchResult result : results) {
                VideoItem item = new VideoItem();
                item.setTitle(result.getSnippet().getTitle());
                item.setDescription(result.getSnippet().getDescription());
                item.setThumbnailURL(result.getSnippet().getThumbnails().getHigh().getUrl());
                item.setId(result.getId().getVideoId());
                items.add(item);
            }

            return items;
        } catch (IOException e) {
            Log.d("YC", "Could not search: " + e);
            return null;
        }
    }

}

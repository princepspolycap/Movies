package com.example.polycap.movies.model;

/**
 * Created by 186 on 2/15/2016.
 */
public class VideoItem {

    private String description;
    private String id;
    private String thumbnailURL;
    private String title;

    public String getDescription() {
        return this.description;
    }

    public String getId() {
        return this.id;
    }

    public String getThumbnailURL() {
        return this.thumbnailURL;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDescription(String var1) {
        this.description = var1;
    }

    public void setId(String var1) {
        this.id = var1;
    }

    public void setThumbnailURL(String var1) {
        this.thumbnailURL = var1;
    }

    public void setTitle(String var1) {
        this.title = var1;
    }
}

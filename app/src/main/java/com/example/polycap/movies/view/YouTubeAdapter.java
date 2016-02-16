package com.example.polycap.movies.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.polycap.movies.R;
import com.example.polycap.movies.model.VideoItem;
import com.example.polycap.movies.view.Activity.PlayerActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 186 on 2/15/2016.
 */
public class YouTubeAdapter extends RecyclerView.Adapter<YouTubeAdapter.MovieDViewHolder> {
    private static final int TYPE_HEADER = 2;
    private static final int TYPE_ITEM = 1;
    MovieDViewHolder holder;
    private List<VideoItem> searchResults = new ArrayList<>();
    private String overviewText;

    public void onBindViewHolder(MovieDViewHolder holder, final int position) {
        this.holder = holder;
        if (position == 0) {
            holder.overviewText.setText(overviewText);
        } else {
            if (this.searchResults != null) {
                VideoItem videoItem = this.searchResults.get(position);
                holder.title.setText(videoItem.getTitle());
                final Context context = holder.thumbnail.getContext();
                Picasso.with(context).setIndicatorsEnabled(false);
                Picasso.with(context).load(Uri.parse(videoItem.getThumbnailURL())).fit().into(holder.thumbnail);
                holder.row.setOnClickListener(var11 -> {
                    Intent keyVideoId = new Intent(context, PlayerActivity.class);
                    keyVideoId.putExtra(PlayerActivity.KEY_VIDEO_ID, (searchResults.get(position)).getId());
                    context.startActivity(keyVideoId);
                });
            }
        }


    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0)return TYPE_HEADER;
        else
        return TYPE_ITEM;
    }

    public MovieDViewHolder onCreateViewHolder(ViewGroup root, int viewType) {
        if(viewType == TYPE_HEADER){
            return new MovieDViewHolder(LayoutInflater.from(root.getContext()).inflate(R.layout.overview_header, root, false));
        }
        return new MovieDViewHolder(LayoutInflater.from(root.getContext()).inflate(R.layout.video_item, root, false));
    }

    public void setSearchResults(List<VideoItem> list) {
        this.searchResults = list;
    }

    public void setOverViewText(String overviewText) {
        this.overviewText = overviewText;
    }

    public int getItemCount() {
        return searchResults.size();
    }


    class MovieDViewHolder extends RecyclerView.ViewHolder {
        private final TextView overviewText;
        public TextView title;
        View row;
        public ImageView thumbnail;

        public MovieDViewHolder(View view) {
            super(view);
            this.thumbnail = (ImageView) view.findViewById(R.id.video_thumbnail);
            this.title = (TextView) view.findViewById(R.id.video_title);
            this.row = view.findViewById(R.id.cardView);
            this.overviewText = (TextView) view.findViewById(R.id.overview);
        }
    }

}

package com.example.polycap.movies.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.polycap.movies.R;
import com.example.polycap.movies.model.MovieResult;
import com.example.polycap.movies.view.Fragments.ItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Polycap on 9/3/2015.
 */
public class MGridViewAdapter extends RecyclerView.Adapter<MGridViewAdapter.GridViewHolder> {

    private final static String IMG_ENDPOINT = "https://image.tmdb.org/t/p/w500/";
    private static final String TAG = MGridViewAdapter.class.getSimpleName();
    public List<MovieResult> results;
    public ItemClickListener itemClickListener;
    private Integer mPosition;
    private GridViewHolder holder;
    private int position;

    public MGridViewAdapter(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.title_grids, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        this.holder = holder;
        this.position = position;
        if (results != null) {
            MovieResult getResults = results.get(position);
            Context context = holder.imageView.getContext();
            Picasso.with(context).setLoggingEnabled(true);
            String imgUrl = IMG_ENDPOINT + getResults.getPosterPath();
            Picasso.with(context).load(imgUrl).into(holder.imageView);
            holder.itemView.setTag(getResults);

            if (getResults.getId() != null){
                Log.v(TAG, "Data is not null");
            }


            holder.imageView.setOnClickListener(v -> itemClickListener.onItemSelected(position));
        }
    }

    @Override
    public int getItemCount() {
        if (results != null)
            return results.size();
        else
            return 0;
    }

    public void sendMovieData(List<MovieResult> data) {
        this.results = data;
    }


    static class GridViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public GridViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.img_thumbnail);
        }

    }

}

package com.example.polycap.movies.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.polycap.movies.R;
import com.example.polycap.movies.model.TvShowsResult;
import com.example.polycap.movies.view.Fragments.ItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Polycap on 9/10/2015.
 */
public class TGridViewAdapter extends RecyclerView.Adapter<TGridViewAdapter.TGridViewHolder> {

    private final static String IMG_ENDPOINT = "https://image.tmdb.org/t/p/w500/";
    private static final String TAG = TGridViewAdapter.class.getSimpleName();
    private List<TvShowsResult> results;
    private ItemClickListener TvitemClickListener;
    private TGridViewHolder holder;
    private int position;

    public TGridViewAdapter(ItemClickListener itemClickListener) {
        this.TvitemClickListener = itemClickListener;
    }

    @Override
    public TGridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.title_grids, parent, false);
        return new TGridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TGridViewHolder holder, int position) {
        this.holder = holder;
        this. position = position;
        if (results != null) {

            TvShowsResult getResults = results.get(position);
            Context context = holder.imageView.getContext();
            Picasso.with(context).setLoggingEnabled(true);
            Log.v(TAG, "On BindView Holder TV");
            String imgUrl = IMG_ENDPOINT + getResults.getPosterPath();
            Log.v(TAG, "img_url =" + imgUrl);
            Picasso.with(context).load(imgUrl).into(holder.imageView);
            holder.itemView.setTag(getResults);

            holder.imageView.setOnClickListener(v -> TvitemClickListener.onItemSelected(position));
        }
    }

    @Override
    public int getItemCount() {
        if (results != null)
            return results.size();
        else
            return 0;
    }

    public void setData(List<TvShowsResult> data) {
        this.results = data;
    }

    static class TGridViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public TGridViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.img_thumbnail);
        }
    }

}



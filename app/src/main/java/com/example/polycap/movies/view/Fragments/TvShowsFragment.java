package com.example.polycap.movies.view.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.polycap.movies.model.TvShowsResult;
import com.example.polycap.movies.view.TvShowsView;

import java.util.List;

/**
 * Created by Polycap on 9/7/2015.
 */
public class TvShowsFragment extends TvShowsView {

    public static TvShowsFragment getInstance(int position) {
        return new TvShowsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void displayData(List<TvShowsResult> results) {
        adapter.setData(results);
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
        adapter.notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return 1;
    }


}

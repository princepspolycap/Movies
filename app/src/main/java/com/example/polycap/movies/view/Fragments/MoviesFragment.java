package com.example.polycap.movies.view.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.polycap.movies.model.MovieResult;
import com.example.polycap.movies.view.MovieView;

import java.util.List;

/**
 * Created by Polycap on 9/3/2015.
 */
@SuppressWarnings("ALL")
public class MoviesFragment extends MovieView {


    public static MoviesFragment getInstance(int position) {
        return new MoviesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void displayData(List<MovieResult> movies) {
        adapter.setData(movies);
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

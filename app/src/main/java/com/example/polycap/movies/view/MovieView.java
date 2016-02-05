package com.example.polycap.movies.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.polycap.movies.R;
import com.example.polycap.movies.model.MovieModel;
import com.example.polycap.movies.model.MovieResult;
import com.example.polycap.movies.presenter.EntertainmentPresenter;
import com.example.polycap.movies.presenter.MoviePresenter;
import com.example.polycap.movies.view.Fragments.ItemClickListener;

import java.util.List;

/**
 * Created by Polycap on 9/4/2015.
 */
public abstract class MovieView extends Fragment implements EntertainmentView, ItemClickListener, SwipeRefreshLayout.OnRefreshListener {
    protected EntertainmentPresenter presenter;
    protected MGridViewAdapter adapter;
    protected SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView recyclerView;
    private View view;
    private List<MovieModel> results;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MoviePresenter(this);
        presenter.getData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.entertainment_fragment, container, false);

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeMovieHits);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false));
        adapter = new MGridViewAdapter(this);
        recyclerView.setAdapter(adapter);

        getData();
        return view;
    }

    @Override
    public void getData() {
        presenter.updateDataFromModel();
    }

    public int getItemCount() {
        if (results != null)
            return results.size();
        else
            return 0;
    }

    @Override
    public void onRefresh() {
        presenter.updateDataFromModel();
    }

    public void displayData(List<MovieResult> results) {
        presenter.getData();
    }

    @Override
    public void onItemSelected(int position) {
        presenter.onItemSelected(position);

    }
}

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
import com.example.polycap.movies.model.TvShowModel;
import com.example.polycap.movies.model.TvShowsResult;
import com.example.polycap.movies.presenter.EntertainmentPresenter;
import com.example.polycap.movies.presenter.TvShowsPresenter;
import com.example.polycap.movies.view.Fragments.ItemClickListener;

import java.util.List;

/**
 * Created by Polycap on 9/7/2015.
 */
public abstract class TvShowsView extends Fragment implements EntertainmentView, ItemClickListener, SwipeRefreshLayout.OnRefreshListener {
    protected TGridViewAdapter adapter;
    protected SwipeRefreshLayout mSwipeRefreshLayout;
    protected EntertainmentPresenter Tvpresenter;
    private List<TvShowModel> tresults;
    private RecyclerView recyclerView;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Tvpresenter = new TvShowsPresenter(this);
        Tvpresenter.getData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.entertainment_fragment, container, false);

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeMovieHits);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false));
        adapter = new TGridViewAdapter(this);
        recyclerView.setAdapter(adapter);

        getData();
        return view;
    }

    @Override
    public void getData() {
        Tvpresenter.updateDataFromModel();
    }

    public int getItemCount() {
        if (tresults != null)
            return tresults.size();
        else
            return 0;
    }

    @Override
    public void onRefresh() {
        Tvpresenter.updateDataFromModel();
    }

    public void displayData(List<TvShowsResult> results) {
        Tvpresenter.displayData();
    }

    @Override
    public void onItemSelected(int position) {
        Tvpresenter.onItemSelected (position);
    }
}

package com.example.polycap.movies.presenter;

import android.content.Intent;
import android.util.Log;

import com.example.polycap.movies.model.TvShowModel;
import com.example.polycap.movies.model.TvShowsResult;
import com.example.polycap.movies.view.Activity.TvShowsDetailsActivity;
import com.example.polycap.movies.view.EntertainmentApp;
import com.example.polycap.movies.view.Fragments.ItemClickListener;
import com.example.polycap.movies.view.TvShowsView;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Polycap on 9/7/2015.
 */
public class TvShowsPresenter implements EntertainmentPresenter, ItemClickListener {
    private static final String TAG = TvShowsPresenter.class.getSimpleName();
    TvShowsView tvShowsView;
    List<TvShowsResult> tvShowsResults;
    int tPosition;

    public TvShowsPresenter(TvShowsView tvShowsView) {
        this.tvShowsView = tvShowsView;
    }

    @Override
    public void updateDataFromModel() {
        TvShowModel tvShowModel = new TvShowModel();
        Observable<TvShowModel> shows = tvShowModel.getTvShowsDataFromServer();
        shows.observeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TvShowModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }


                    @Override
                    public void onNext(TvShowModel tvShowModel) {
                        Log.v(TAG, "Tv Results Size: " + tvShowModel.getTvShowsResults().size());
                        tvShowsResults = tvShowModel.getTvShowsResults();
                        updateTvView(tvShowModel.getTvShowsResults());
                    }
                });
    }

    protected void updateTvView(List<TvShowsResult> tvShowsResults) {
        tvShowsView.displayData(tvShowsResults);
    }

    @Override
    public void getData() {
    }

    @Override
    public void displayData() {
    }

    @Override
    public void onItemSelected(int position) {
        Log.v(TAG, "onItemSelected");
        tPosition = tvShowsResults.get(position).getId();
        Intent tvIntent = new Intent(EntertainmentApp.getContext(), TvShowsDetailsActivity.class);
        tvIntent.putExtra("id", tPosition);
        Log.v(TAG,"TV Position clicked" + tPosition);
        tvShowsView.getActivity().startActivity(tvIntent);
    }
}

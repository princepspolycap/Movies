package com.example.polycap.movies.presenter;

import android.util.Log;

import com.example.polycap.movies.model.SearchYoutube;
import com.example.polycap.movies.model.TvDetailsModel;
import com.example.polycap.movies.model.VideoItem;
import com.example.polycap.movies.view.Activity.TvDetails;
import com.example.polycap.movies.view.EntertainmentApp;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Polycap on 11/9/2015.
 */
public class TvDetailsPresenter {
    private static final String TAG = TvDetailsPresenter.class.getSimpleName();

    TvDetails tView;

    public TvDetailsPresenter(TvDetails tvDetails) {
        this.tView = tvDetails;
    }

    public void getData(int id) {

        Observable<TvDetailsModel> tvShowModelObservable = TvDetailsModel.requestTvShowDetails(String.valueOf(id));
        tvShowModelObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(tvDetailsModel -> {
                    Log.v(TAG, "fetched details successfully");
                    sendData(tvDetailsModel);
                }, Throwable::printStackTrace);
    }

    public void sendData(TvDetailsModel tvDetailsModel) {
        tView.displayData(tvDetailsModel);
    }


    public void searchOnYoutube(final String title) {
        Observable.create(new Observable.OnSubscribe<List<VideoItem>>() {
            @Override
            public void call(Subscriber<? super List<VideoItem>> subscriber) {
                SearchYoutube searchYoutube = new SearchYoutube(EntertainmentApp.getContext());
                subscriber.onNext(searchYoutube.search(title));
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::updatingTvVideo, Throwable::printStackTrace);
    }

    private void updatingTvVideo(List<VideoItem> videoItems) {
        tView.getDetailsData(videoItems);
    }


}

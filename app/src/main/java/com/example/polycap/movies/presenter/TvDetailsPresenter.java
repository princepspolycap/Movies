package com.example.polycap.movies.presenter;

import android.util.Log;

import com.example.polycap.movies.rest.models.TvDetailsModel;
import com.example.polycap.movies.view.Activity.TvDetails;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Polycap on 11/9/2015.
 */
public class TvDetailsPresenter {
    private static final String TAG = TvDetailsPresenter.class.getSimpleName();

    TvDetails tView;

    public TvDetailsPresenter (TvDetails tvDetails){
        this.tView = tvDetails;
    }

    public void getData(int id){

        Observable<TvDetailsModel> tvShowModelObservable = TvDetailsModel.requestTvShowDetails(String.valueOf(id));
        tvShowModelObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(tvDetailsModel -> {
                    Log.v(TAG, "fetched details successfully");
                    sendData(tvDetailsModel);
                }, Throwable::printStackTrace);
    }

    public void sendData(TvDetailsModel tvDetailsModel){
        tView.displayData(tvDetailsModel);
    }
}

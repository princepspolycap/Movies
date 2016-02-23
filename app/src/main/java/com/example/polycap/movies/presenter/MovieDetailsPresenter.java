package com.example.polycap.movies.presenter;

import com.example.polycap.movies.model.MovieDetailsModel;
import com.example.polycap.movies.model.VideoItem;
import com.example.polycap.movies.model.SearchYoutube;
import com.example.polycap.movies.view.Activity.MovieDetailsI;
import com.example.polycap.movies.view.EntertainmentApp;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Polycap on 2/6/2016.
 */
public class MovieDetailsPresenter {

    MovieDetailsI movieDetailsI;

    public MovieDetailsPresenter(MovieDetailsI movieDetailsI) {
        this.movieDetailsI = movieDetailsI;
    }


    public void getMoviesDetailsData(int id) {

        Observable<MovieDetailsModel> detailsModelObservable = MovieDetailsModel.requestMovieDetails(String.valueOf(id));
        detailsModelObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::sendMovieDetails, Throwable::printStackTrace);
    }

    private void sendMovieDetails(MovieDetailsModel movieDetailsModel) {
        movieDetailsI.displayMovieData(movieDetailsModel);
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
                .subscribe(this::updateVideosFound, Throwable::printStackTrace);
    }


    public void updateVideosFound(List<VideoItem> youtubeVideos) {
        movieDetailsI.getYoutubeData(youtubeVideos);
    }
}

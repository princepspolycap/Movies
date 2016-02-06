package com.example.polycap.movies.presenter;

import com.example.polycap.movies.model.MovieDetailsModel;
import com.example.polycap.movies.view.Activity.MovieDetailsI;
import com.example.polycap.movies.view.Activity.TvDetails;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Polycap on 2/6/2016.
 */
public class MovieDetailsPresenter {

   MovieDetailsI movieDetailsI;

    public MovieDetailsPresenter (MovieDetailsI movieDetailsI){
        this.movieDetailsI = movieDetailsI;
    }


    public void getMovieDdata(int id ){

        Observable<MovieDetailsModel> detailsModelObservable = MovieDetailsModel.requestMovieDetails(String.valueOf(id));
        detailsModelObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(movieDetailsModel -> {
                    sendMovieDdata(movieDetailsModel);
                },Throwable::printStackTrace);
    }

    private void sendMovieDdata(MovieDetailsModel movieDetailsModel) {
        movieDetailsI.displayMovieData(movieDetailsModel);
    }

}

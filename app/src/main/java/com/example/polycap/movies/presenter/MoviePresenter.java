package com.example.polycap.movies.presenter;

import android.content.Intent;
import android.util.Log;

import com.example.polycap.movies.model.MovieModel;
import com.example.polycap.movies.model.MovieResult;
import com.example.polycap.movies.view.Activity.MovieDetailsActivity;
import com.example.polycap.movies.view.EntertainmentApp;
import com.example.polycap.movies.view.Fragments.ItemClickListener;
import com.example.polycap.movies.view.MovieView;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Polycap on 9/5/2015.
 */
public class MoviePresenter implements EntertainmentPresenter, ItemClickListener {

    private static final String TAG = MovieDetailsActivity.class.getSimpleName();
    MovieView movieView;
    List<MovieResult> movieResults;
    int mPosition;

    public MoviePresenter(MovieView movieView) {
        this.movieView = movieView;
    }

    @Override
    public void updateDataFromModel() {
        MovieModel movieModel = new MovieModel();
        Observable<MovieModel> movies = movieModel.getMovieDatafromServer();
        movies.observeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieModel>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(MovieModel movies) {
                        movieResults = movies.getResults();
                        updateMovieView(movies.getResults());
                    }
                });
    }


    protected void updateMovieView(List<MovieResult> movies) {
        movieView.displayData(movies);
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
        mPosition = movieResults.get(position).getId();
        Intent mMovieIdIntent = new Intent(EntertainmentApp.getContext(), MovieDetailsActivity.class);
        mMovieIdIntent.putExtra("id",mPosition);
        Log.v(TAG, "Position clicked " + mPosition);
        movieView.getActivity().startActivity(mMovieIdIntent);
    }
}

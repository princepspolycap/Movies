package com.example.polycap.movies.view.Activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.polycap.movies.R;
import com.example.polycap.movies.model.MovieDetailsModel;
import com.example.polycap.movies.presenter.MovieDetailsPresenter;
import com.example.polycap.movies.view.EntertainmentApp;
import com.squareup.picasso.Picasso;

/**
 * Created by Polycap on 1/31/2016.
 */
public class MovieDetailsActivity extends AppCompatActivity implements MovieDetailsI{

    private final static String IMG_ENDPOINT = "https://image.tmdb.org/t/p/w500/";

    public Toolbar toolbar;
    public CollapsingToolbarLayout mcollapsingtoolbar;
    protected MovieDetailsPresenter movieDetailsPresenter;
    EntertainmentApp getContext;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_entertainment);
////        toolbar= (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

        int id;
        id = getIntent().getExtras().getInt("id");
        movieDetailsPresenter = new MovieDetailsPresenter(this);
        movieDetailsPresenter.getMovieDdata(id);

    }

    @Override
    public void displayMovieData(MovieDetailsModel movieDetailsModel) {
//        Setting up view with data

        String title = movieDetailsModel.getTitle();
        mcollapsingtoolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mcollapsingtoolbar.setTitle(title);
        mcollapsingtoolbar.setExpandedTitleTextAppearance(R.style.CollapsedAppBar);
        mcollapsingtoolbar.setExpandedTitleTextAppearance(R.style.CollapsedAppBar);


        ImageView mbackdrop = (ImageView) findViewById(R.id.backdrop);
        Picasso.with(getContext).setLoggingEnabled(true);
        String mbackdropUrl = IMG_ENDPOINT+movieDetailsModel.getBackdropPath();
        Picasso.with(getContext).load(mbackdropUrl).into(mbackdrop);
        TextView mOverview = (TextView) findViewById(R.id.overview);
        mOverview.setText(movieDetailsModel.getOverview());




    }
}

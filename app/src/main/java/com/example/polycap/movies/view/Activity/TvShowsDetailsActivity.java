package com.example.polycap.movies.view.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.polycap.movies.R;
import com.example.polycap.movies.presenter.TvDetailsPresenter;
import com.example.polycap.movies.rest.models.TvDetailsModel;
import com.example.polycap.movies.view.EntertainmentApp;
import com.squareup.picasso.Picasso;

/**
 * Created by Polycap on 1/31/2016.
 */
public class TvShowsDetailsActivity extends AppCompatActivity implements TvDetails {

    private final static String IMG_ENDPOINT = "https://image.tmdb.org/t/p/w500/";

    public Toolbar toolbr;
    public CollapsingToolbarLayout collapsingToolbarLayout;
    protected TvDetailsPresenter presenter;
    EntertainmentApp getContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_entertainment);

        toolbr = (Toolbar) findViewById(R.id.toolbr);
        setSupportActionBar(toolbr);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        int id;
        id = getIntent().getExtras().getInt("id");
        presenter = new TvDetailsPresenter(this);
        presenter.getData(id);

    }


    @Override
    public void displayData(TvDetailsModel tvShowModel) {
        //set up view with data
        String title =  tvShowModel.getName();
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(title);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.CollapsedAppBar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.CollapsedAppBar);

        ImageView backdrop = (ImageView) findViewById(R.id.backdrop);
        Picasso.with(getContext).setLoggingEnabled(true);
        String backdrpUrl = IMG_ENDPOINT + tvShowModel.getBackdropPath();
        Picasso.with(getContext).load(backdrpUrl).into(backdrop);

        TextView overView= (TextView) findViewById(R.id.overview);
        overView.setText(tvShowModel.getOverview());




    }



}

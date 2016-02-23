package com.example.polycap.movies.view.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.polycap.movies.R;
import com.example.polycap.movies.model.VideoItem;
import com.example.polycap.movies.presenter.TvDetailsPresenter;
import com.example.polycap.movies.model.TvDetailsModel;
import com.example.polycap.movies.view.EntertainmentApp;
import com.example.polycap.movies.view.YouTubeAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Polycap on 1/31/2016.
 */
public class TvShowsDetailsActivity extends AppCompatActivity implements TvDetails {

    private final static String IMG_ENDPOINT = "https://image.tmdb.org/t/p/w500/";

    public Toolbar toolbar;
    public CollapsingToolbarLayout collapsingToolbarLayout;
    protected TvDetailsPresenter tvDetailsPresenter;
    EntertainmentApp getContext;
    private YouTubeAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_entertainment);

        int id;
        id = getIntent().getExtras().getInt("id");

        recyclerView = (RecyclerView) findViewById(R.id.YoutubeRecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new YouTubeAdapter();
        recyclerView.setAdapter(adapter);


        toolbar = (Toolbar) findViewById(R.id.detailstoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvDetailsPresenter = new TvDetailsPresenter(this);
        tvDetailsPresenter.getData(id);

    }


    @Override
    public void displayData(TvDetailsModel tvShowModel) {
        //set up view with data
        String title = tvShowModel.getName();
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(title);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.CollapsedAppBar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.CollapsedAppBar);

        ImageView backdrop = (ImageView) findViewById(R.id.backdrop);
        Picasso.with(getContext).setLoggingEnabled(true);
        String backdrpUrl = IMG_ENDPOINT + tvShowModel.getBackdropPath();
        Picasso.with(getContext).load(backdrpUrl).into(backdrop);
        adapter.setOverViewText(tvShowModel.getOverview());

        tvDetailsPresenter.searchOnYoutube(title);

    }

    @Override
    public void getDetailsData(List<VideoItem> videoItems) {
        adapter.setSearchResults(videoItems);
        adapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), EntertainmentActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }


}

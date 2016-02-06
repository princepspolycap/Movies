package com.example.polycap.movies.view.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.polycap.movies.R;

/**
 * Created by Polycap on 1/31/2016.
 */
public class MovieDetailsActivity extends AppCompatActivity{

    public static final String EXTRA_NAME = "movie id";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_entertainment);



    }
}

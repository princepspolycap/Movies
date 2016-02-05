package com.example.polycap.movies.view;

import android.app.Application;
import android.content.Context;

/**
 * Created by Polycap on 9/6/2015.
 */
public class EntertainmentApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}

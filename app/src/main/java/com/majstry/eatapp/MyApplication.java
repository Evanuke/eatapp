package com.majstry.eatapp;

import android.app.Application;

import com.majstry.eatapp.activities.MainActivity;
import com.majstry.eatapp.fragments.MainFragment;

public class MyApplication extends Application{

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }

    public static void inject(MainActivity mainActivity) {
        appComponent.inject(mainActivity);
    }

    public static void inject(MainFragment mainFragment) {
        appComponent.inject(mainFragment);
    }

}

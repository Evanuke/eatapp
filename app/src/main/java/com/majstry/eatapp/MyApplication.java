package com.majstry.eatapp;

import android.app.Application;

import com.majstry.eatapp.activities.MainActivity;
import com.majstry.eatapp.fragments.MainFragment;
import com.majstry.eatapp.fragments.MenuFragment;
import com.majstry.eatapp.fragments.OrderFragment;
import com.majstry.eatapp.presenters.MenuFragmentPresenter;
import com.majstry.eatapp.presenters.OrderFragmentPresenter;

import javax.inject.Inject;

public class MyApplication extends Application {

    private static AppComponent appComponent;

    @Inject
    DataStore mDataStore;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);

        mDataStore.prepareMockups();
    }

    public static void inject(MainActivity mainActivity) {
        appComponent.inject(mainActivity);
    }

    public static void inject(MenuFragmentPresenter menuFragmentPresenter) {
        appComponent.inject(menuFragmentPresenter);
    }

    public static void inject(MainFragment mainFragment) {
        appComponent.inject(mainFragment);
    }

    public static void inject(OrderFragmentPresenter orderFragmentPresenter) {
        appComponent.inject(orderFragmentPresenter);
    }

}

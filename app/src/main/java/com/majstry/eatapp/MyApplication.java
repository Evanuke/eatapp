package com.majstry.eatapp;

import android.app.Application;

import com.majstry.eatapp.activities.MainActivity;
import com.majstry.eatapp.fragments.MainFragment;
import com.majstry.eatapp.fragments.MenuFragment;
import com.majstry.eatapp.fragments.OrderFragment;
import com.majstry.eatapp.fragments.YourOrdersFragment;
import com.majstry.eatapp.presenters.MainFragmentPresenter;
import com.majstry.eatapp.presenters.MenuFragmentPresenter;
import com.majstry.eatapp.presenters.OrderDetailsFragmentPresenter;
import com.majstry.eatapp.presenters.OrderFragmentPresenter;
import com.majstry.eatapp.presenters.RatingsFragmentPresenter;
import com.majstry.eatapp.presenters.SpecialOffersFragmentPresenter;
import com.majstry.eatapp.presenters.YourOrdersFragmentPresenter;

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

    public static void inject(RatingsFragmentPresenter ratingsFragmentPresenter) {
        appComponent.inject(ratingsFragmentPresenter);
    }

    public static void inject(MenuFragmentPresenter menuFragmentPresenter) {
        appComponent.inject(menuFragmentPresenter);
    }

    public static void inject(SpecialOffersFragmentPresenter specialOffersFragmentPresenter) {
        appComponent.inject(specialOffersFragmentPresenter);
    }

    public static void inject(MainFragmentPresenter mainFragmentPresenter) {
        appComponent.inject(mainFragmentPresenter);
    }

    public static void inject(OrderFragmentPresenter orderFragmentPresenter) {
        appComponent.inject(orderFragmentPresenter);
    }

    public static void inject(OrderDetailsFragmentPresenter orderDetailsFragmentPresenter) {
        appComponent.inject(orderDetailsFragmentPresenter);
    }

    public static void inject(YourOrdersFragmentPresenter yourOrdersFragmentPresenter) {
        appComponent.inject(yourOrdersFragmentPresenter);
    }

}

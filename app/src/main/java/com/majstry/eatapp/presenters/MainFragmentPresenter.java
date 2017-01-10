package com.majstry.eatapp.presenters;

import com.majstry.eatapp.DataStore;
import com.majstry.eatapp.MyApplication;
import com.majstry.eatapp.fragments.MainFragment;
import com.majstry.eatapp.fragments.SpecialOffersFragment;
import com.majstry.eatapp.models.MenuItem;
import com.majstry.eatapp.models.News;
import com.majstry.eatapp.models.SpecialOffer;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainFragmentPresenter {

    @Inject
    DataStore mDataStore;

    private MainFragment mFragment;

    public MainFragmentPresenter(MainFragment mainFragment) {
        mFragment = mainFragment;

        MyApplication.inject(this);
    }

    public ArrayList<News> getNewses() {
        return mDataStore.getNewses();
    }

}

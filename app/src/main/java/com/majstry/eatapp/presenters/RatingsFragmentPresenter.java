package com.majstry.eatapp.presenters;

import com.majstry.eatapp.DataStore;
import com.majstry.eatapp.MyApplication;
import com.majstry.eatapp.fragments.MenuFragment;
import com.majstry.eatapp.fragments.RatingsFragment;
import com.majstry.eatapp.models.MenuItem;
import com.majstry.eatapp.models.Rating;

import java.util.ArrayList;

import javax.inject.Inject;

public class RatingsFragmentPresenter {

    @Inject
    DataStore mDataStore;

    private RatingsFragment mFragment;

    public RatingsFragmentPresenter(RatingsFragment ratingsFragment) {
        mFragment = ratingsFragment;

        MyApplication.inject(this);
    }

    public ArrayList<Rating> getRatings() {
        return mDataStore.getRatings();
    }

}

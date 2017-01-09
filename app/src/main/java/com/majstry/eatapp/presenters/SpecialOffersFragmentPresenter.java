package com.majstry.eatapp.presenters;

import com.majstry.eatapp.DataStore;
import com.majstry.eatapp.MyApplication;
import com.majstry.eatapp.fragments.MenuFragment;
import com.majstry.eatapp.fragments.SpecialOffersFragment;
import com.majstry.eatapp.models.MenuItem;
import com.majstry.eatapp.models.SpecialOffer;

import java.util.ArrayList;

import javax.inject.Inject;

public class SpecialOffersFragmentPresenter {

    @Inject
    DataStore mDataStore;

    private SpecialOffersFragment mFragment;

    public SpecialOffersFragmentPresenter(SpecialOffersFragment specialOffersFragment) {
        mFragment = specialOffersFragment;

        MyApplication.inject(this);
    }

    public ArrayList<SpecialOffer> getSpecialOffers() {
        return mDataStore.getSpecialOffers();
    }

    public ArrayList<MenuItem> getMenuItems() {
        return mDataStore.getMenuItems();
    }

    public void setDiscountMenuItem(MenuItem menuItem) {
        mDataStore.setDiscountMenuItem(menuItem);
    }

}

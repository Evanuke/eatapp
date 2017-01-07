package com.majstry.eatapp.presenters;

import com.majstry.eatapp.DataStore;
import com.majstry.eatapp.MyApplication;
import com.majstry.eatapp.fragments.MenuFragment;
import com.majstry.eatapp.models.MenuItem;

import java.util.ArrayList;

import javax.inject.Inject;

public class MenuFragmentPresenter {

    @Inject
    DataStore mDataStore;

    private MenuFragment mFragment;

    public MenuFragmentPresenter(MenuFragment menuFragment) {
        mFragment = menuFragment;

        MyApplication.inject(this);
    }

    public ArrayList<MenuItem> getMenuItems() {
        return mDataStore.getMenuItems();
    }

}

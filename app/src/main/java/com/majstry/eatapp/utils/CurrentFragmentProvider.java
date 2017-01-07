package com.majstry.eatapp.utils;

import android.support.v4.app.Fragment;

import com.majstry.eatapp.base.BaseFragment;

public class CurrentFragmentProvider {

    private static CurrentFragmentProvider sInstance;
    private Fragment mCurrentFragment;

    private CurrentFragmentProvider() {

    }

    public static CurrentFragmentProvider getInstance() {
        if (sInstance == null) {
            sInstance = new CurrentFragmentProvider();
        }

        return sInstance;
    }

    public void setCurrentFragment(BaseFragment fragment) {
        mCurrentFragment = fragment;
    }
    
    public Fragment getCurrentFragment() {
        return mCurrentFragment;
    }

}

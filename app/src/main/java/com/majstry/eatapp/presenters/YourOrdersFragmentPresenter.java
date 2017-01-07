package com.majstry.eatapp.presenters;

import android.os.Handler;

import com.majstry.eatapp.DataStore;
import com.majstry.eatapp.MyApplication;
import com.majstry.eatapp.fragments.MenuFragment;
import com.majstry.eatapp.fragments.YourOrdersFragment;
import com.majstry.eatapp.models.MenuItem;
import com.majstry.eatapp.models.interfaces.MenuItemInterface;
import com.majstry.eatapp.states.DataLoadedState;
import com.majstry.eatapp.states.LoadingState;
import com.majstry.eatapp.states.NoContentState;
import com.majstry.eatapp.states.StateInterface;

import java.util.ArrayList;

import javax.inject.Inject;

public class YourOrdersFragmentPresenter {

    @Inject
    DataStore mDataStore;

    private YourOrdersFragment mFragment;

    private ArrayList<MenuItemInterface> mOrders;

    public YourOrdersFragmentPresenter(YourOrdersFragment yourOrdersFragment) {
        mFragment = yourOrdersFragment;

        MyApplication.inject(this);
        mOrders = new ArrayList<>();

        LoadingState loadingState = new LoadingState();
        loadingState.manageView(mFragment);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mOrders = mDataStore.getOrders();

                StateInterface state = mOrders.size() > 0 ? new DataLoadedState() : new NoContentState();
                state.manageView(mFragment);

                mFragment.onDataLoaded(mOrders);
            }
        }, 2000);
    }

}

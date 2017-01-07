package com.majstry.eatapp.states;

import android.view.View;

import com.majstry.eatapp.fragments.YourOrdersFragment;

public class DataLoadedState implements StateInterface {
    @Override
    public void manageView(YourOrdersFragment yourOrdersFragment) {
        yourOrdersFragment.getBlockView().setVisibility(View.GONE);
        yourOrdersFragment.getNoContentView().setVisibility(View.GONE);
        yourOrdersFragment.getDataView().setVisibility(View.VISIBLE);
    }
}

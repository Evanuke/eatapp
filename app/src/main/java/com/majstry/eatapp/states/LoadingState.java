package com.majstry.eatapp.states;

import android.view.View;

import com.majstry.eatapp.fragments.YourOrdersFragment;

public class LoadingState implements StateInterface {
    @Override
    public void manageView(YourOrdersFragment yourOrdersFragment) {
        yourOrdersFragment.getBlockView().setVisibility(View.VISIBLE);
        yourOrdersFragment.getNoContentView().setVisibility(View.GONE);
        yourOrdersFragment.getDataView().setVisibility(View.GONE);
    }
}

package com.majstry.eatapp.states;

import android.view.View;

import com.majstry.eatapp.fragments.YourOrdersFragment;

public class NoContentState implements StateInterface {
    @Override
    public void manageView(YourOrdersFragment yourOrdersFragment) {
        yourOrdersFragment.getBlockView().setVisibility(View.GONE);
        yourOrdersFragment.getNoContentView().setVisibility(View.VISIBLE);
        yourOrdersFragment.getDataView().setVisibility(View.GONE);
    }
}

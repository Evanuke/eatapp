package com.majstry.eatapp.presenters;

import com.majstry.eatapp.DataStore;
import com.majstry.eatapp.MyApplication;
import com.majstry.eatapp.fragments.OrderDetailsFragment;
import com.majstry.eatapp.fragments.OrderFragment;
import com.majstry.eatapp.models.MenuItem;
import com.majstry.eatapp.models.MenuItemDecorator;
import com.majstry.eatapp.models.interfaces.MenuItemInterface;

import java.util.ArrayList;

import javax.inject.Inject;

public class OrderDetailsFragmentPresenter {

    @Inject
    DataStore mDataStore;

    private MenuItemInterface mMenuItem;

    private OrderDetailsFragment mFragment;

    public OrderDetailsFragmentPresenter(OrderDetailsFragment orderDetailsFragment) {
        mFragment = orderDetailsFragment;
        MyApplication.inject(this);
    }

    public void setCurrentItem(MenuItemInterface menuItem) {
        mMenuItem = menuItem;
    }

    public MenuItemInterface getMenuItem() {
        return mMenuItem;
    }

    public void saveOrder() {
        mDataStore.saveOrder(mMenuItem);
    }

}

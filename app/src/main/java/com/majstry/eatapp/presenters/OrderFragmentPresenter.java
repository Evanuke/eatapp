package com.majstry.eatapp.presenters;

import android.os.Bundle;

import com.majstry.eatapp.DataStore;
import com.majstry.eatapp.MyApplication;
import com.majstry.eatapp.activities.OrderActivity;
import com.majstry.eatapp.base.BaseFragment;
import com.majstry.eatapp.fragments.OrderDetailsFragment;
import com.majstry.eatapp.fragments.OrderFragment;
import com.majstry.eatapp.models.MenuItem;
import com.majstry.eatapp.models.MenuItemDecorator;
import com.majstry.eatapp.models.interfaces.MenuItemInterface;

import java.util.ArrayList;

import javax.inject.Inject;

public class OrderFragmentPresenter {

    @Inject
    DataStore mDataStore;

    private ArrayList<MenuItemDecorator> mIngredients;
    private ArrayList<MenuItem> mMenuItems;
    private ArrayList<MenuItemDecorator> mUsedIngredients;

    private MenuItemInterface mMenuItem;

    private OrderFragment mFragment;

    public OrderFragmentPresenter(OrderFragment orderFragment) {
        mFragment = orderFragment;
        MyApplication.inject(this);

        mIngredients = mDataStore.getIngredients();
        mMenuItems = mDataStore.getMenuItems();

        mUsedIngredients = new ArrayList<>();
    }

    public void setMenuItem(MenuItemInterface menuItem) {
        mMenuItem = menuItem;
    }

    public MenuItemInterface getMenuItem() {
        return mMenuItem;
    }

    public ArrayList<MenuItemDecorator> getIngredients() {
        return mIngredients;
    }

    public ArrayList<MenuItem> getAllMenuItems() {
        return mMenuItems;
    }

    public void setSelectedMenuItemPosition(int position) {
        mMenuItem = mMenuItems.get(position);
        refreshIngredients();
    }

    private void refreshIngredients() {
        mIngredients = mDataStore.getIngredients();
        mUsedIngredients = new ArrayList<>();
    }

    private void moveIngredientToUsed(MenuItemDecorator ingredient) {
        mUsedIngredients.add(ingredient);
        mIngredients.remove(ingredient);
    }

    public void addIngredientFromPosition(int position) {
        MenuItemDecorator ingredient = mIngredients.get(position);
        ingredient.setMenuItem(mMenuItem);
        moveIngredientToUsed(ingredient);

        mMenuItem = ingredient;
    }

    public ArrayList<MenuItemDecorator> getUsedIngredients() {
        return mUsedIngredients;
    }

    public void proceedToConfirmation() {
        OrderActivity orderActivity = (OrderActivity) mFragment.getActivity();
        BaseFragment fragment = new OrderDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(OrderDetailsFragment.ORDERED_ITEM, mMenuItem);
        fragment.setArguments(bundle);
        orderActivity.changeFragment(fragment);
    }

}

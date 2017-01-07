package com.majstry.eatapp.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.majstry.eatapp.DataStore;
import com.majstry.eatapp.MyApplication;
import com.majstry.eatapp.R;
import com.majstry.eatapp.adapters.MenuItemRecyclerAdapter;
import com.majstry.eatapp.base.BaseFragment;
import com.majstry.eatapp.models.MenuItem;
import com.majstry.eatapp.presenters.MenuFragmentPresenter;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuFragment extends BaseFragment {

    private MenuFragmentPresenter mPresenter;

    @BindView(R.id.fragment_menu_rv)
    RecyclerView mMenuRv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        ButterKnife.bind(this, view);
        mPresenter = new MenuFragmentPresenter(this);

        setupMenuItems();

        return view;
    }

    private void setupMenuItems() {
        ArrayList<MenuItem> menuItems = mPresenter.getMenuItems();

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        MenuItemRecyclerAdapter adapter = new MenuItemRecyclerAdapter(getContext(), menuItems);

        mMenuRv.setAdapter(adapter);
        mMenuRv.setLayoutManager(manager);
    }
}
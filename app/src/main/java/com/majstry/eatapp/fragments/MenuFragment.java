package com.majstry.eatapp.fragments;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.majstry.eatapp.R;
import com.majstry.eatapp.adapters.MenuItemRecyclerAdapter;
import com.majstry.eatapp.base.BaseFragment;
import com.majstry.eatapp.models.MenuItem;
import com.majstry.eatapp.models.interfaces.OnMenuItemClickListener;
import com.majstry.eatapp.presenters.MenuFragmentPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuFragment extends BaseFragment implements OnMenuItemClickListener {

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
        adapter.setOnMenuItemClickListener(this);
        mMenuRv.setAdapter(adapter);
        mMenuRv.setLayoutManager(manager);
    }

    @Override
    public void onMenuItemClicked(MenuItem menuItem) {
        new MaterialDialog.Builder(getContext())
                .title(menuItem.getName())
                .positiveColorRes(R.color.accent)
                .negativeColorRes(R.color.accent)
                .content(menuItem.getDescription() + "\n"
                        + menuItem.getPrice())
                .positiveText("OK")
                .canceledOnTouchOutside(true)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }
}

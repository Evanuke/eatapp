package com.majstry.eatapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.majstry.eatapp.R;
import com.majstry.eatapp.adapters.MenuItemRecyclerAdapter;
import com.majstry.eatapp.adapters.RatingsRecyclerAdapter;
import com.majstry.eatapp.base.BaseFragment;
import com.majstry.eatapp.models.MenuItem;
import com.majstry.eatapp.models.Rating;
import com.majstry.eatapp.models.interfaces.OnMenuItemClickListener;
import com.majstry.eatapp.presenters.MenuFragmentPresenter;
import com.majstry.eatapp.presenters.RatingsFragmentPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RatingsFragment extends BaseFragment {

    private RatingsFragmentPresenter mPresenter;

    @BindView(R.id.fragment_ratings_rv)
    RecyclerView mRatingsRv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ratings, container, false);

        ButterKnife.bind(this, view);
        mPresenter = new RatingsFragmentPresenter(this);

        setupRatings();

        return view;
    }

    private void setupRatings() {
        ArrayList<Rating> ratings = mPresenter.getRatings();

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        RatingsRecyclerAdapter adapter = new RatingsRecyclerAdapter(getContext(), ratings);
        mRatingsRv.setAdapter(adapter);
        mRatingsRv.setLayoutManager(manager);
    }
}

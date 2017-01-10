package com.majstry.eatapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.majstry.eatapp.MyApplication;
import com.majstry.eatapp.R;
import com.majstry.eatapp.activities.MenuActivity;
import com.majstry.eatapp.activities.OrderActivity;
import com.majstry.eatapp.adapters.NewsRecyclerAdapter;
import com.majstry.eatapp.adapters.SpecialOfferRecyclerAdapter;
import com.majstry.eatapp.base.BaseFragment;
import com.majstry.eatapp.models.MenuItem;
import com.majstry.eatapp.models.News;
import com.majstry.eatapp.models.SpecialOffer;
import com.majstry.eatapp.models.interfaces.OnNewsClickListener;
import com.majstry.eatapp.presenters.MainFragmentPresenter;
import com.majstry.eatapp.presenters.SpecialOffersFragmentPresenter;
import com.majstry.eatapp.utils.snackbars.SnackbarUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainFragment extends BaseFragment implements OnNewsClickListener {

    private MainFragmentPresenter mPresenter;

    @BindView(R.id.fragment_main_rv)
    RecyclerView mNewsRv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, view);
        mPresenter = new MainFragmentPresenter(this);

        setupNews();

        return view;
    }

    private void setupNews() {
        ArrayList<News> news = mPresenter.getNewses();

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        NewsRecyclerAdapter adapter = new NewsRecyclerAdapter(getContext(), news);
        adapter.setOnNewsClickListener(this);
        mNewsRv.setAdapter(adapter);
        mNewsRv.setLayoutManager(manager);
    }


    @Override
    public void onNewsClicked(News news) {

    }
}

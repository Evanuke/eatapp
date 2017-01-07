package com.majstry.eatapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.majstry.eatapp.MyApplication;
import com.majstry.eatapp.R;
import com.majstry.eatapp.activities.MenuActivity;
import com.majstry.eatapp.activities.OrderActivity;
import com.majstry.eatapp.base.BaseFragment;
import com.majstry.eatapp.utils.snackbars.SnackbarUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        MyApplication.inject(this);
        ButterKnife.bind(this, view);

        return view;
    }
}

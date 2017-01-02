package com.majstry.eatapp.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.majstry.eatapp.MyApplication;
import com.majstry.eatapp.R;

import butterknife.ButterKnife;

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        MyApplication.inject(this);
        ButterKnife.bind(this, view);

        return view;
    }
}

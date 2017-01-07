package com.majstry.eatapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.majstry.eatapp.utils.CurrentFragmentProvider;

public class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CurrentFragmentProvider.getInstance().setCurrentFragment(this);
    }
}

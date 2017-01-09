package com.majstry.eatapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.majstry.eatapp.R;
import com.majstry.eatapp.adapters.MenuItemRecyclerAdapter;
import com.majstry.eatapp.adapters.SpecialOfferRecyclerAdapter;
import com.majstry.eatapp.base.BaseFragment;
import com.majstry.eatapp.models.MenuItem;
import com.majstry.eatapp.models.SpecialOffer;
import com.majstry.eatapp.models.interfaces.OnSpecialOfferClickListener;
import com.majstry.eatapp.presenters.SpecialOffersFragmentPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpecialOffersFragment extends BaseFragment implements OnSpecialOfferClickListener {

    private SpecialOffersFragmentPresenter mPresenter;

    @BindView(R.id.fragment_special_offers_rv)
    RecyclerView mMenuRv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_special_offers, container, false);

        ButterKnife.bind(this, view);
        mPresenter = new SpecialOffersFragmentPresenter(this);

        setupSpecialOffers();

        return view;
    }

    private void setupSpecialOffers() {
        ArrayList<SpecialOffer> specialOffers = mPresenter.getSpecialOffers();

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        SpecialOfferRecyclerAdapter adapter = new SpecialOfferRecyclerAdapter(getContext(), specialOffers);
        adapter.setOnSpecialOfferClickListener(this);
        mMenuRv.setAdapter(adapter);
        mMenuRv.setLayoutManager(manager);
    }

    @Override
    public void onSpecialOfferClicked(SpecialOffer specialOffer) {
        ArrayList<MenuItem> menuItems = mPresenter.getMenuItems();
        for (MenuItem m : menuItems) {
            if (m.getName().equals(specialOffer.getName()) && !specialOffer.isTaken()) {
                m.setPrice(m.getPrice() * specialOffer.getDiscount());
                specialOffer.setTaken(true);
                mPresenter.setDiscountMenuItem(m);
                int discount = (int) (specialOffer.getDiscount() * 100);
                Toast.makeText(getContext(), "Nadano zniżkę " + String.valueOf(discount) + "%", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        Toast.makeText(getContext(), "Zniżka wykorzystana", Toast.LENGTH_SHORT).show();
    }

}

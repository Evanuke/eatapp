package com.majstry.eatapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.majstry.eatapp.R;
import com.majstry.eatapp.activities.YourOrdersActivity;
import com.majstry.eatapp.base.BaseFragment;
import com.majstry.eatapp.models.interfaces.MenuItemInterface;
import com.majstry.eatapp.presenters.OrderDetailsFragmentPresenter;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderDetailsFragment extends BaseFragment implements MaterialSpinner.OnItemSelectedListener {

    public static final String ORDERED_ITEM = "ordered_item";

    private OrderDetailsFragmentPresenter mPresenter;

    @BindView(R.id.fragment_order_details_iv)
    ImageView mOrderIv;

    @BindView(R.id.fragment_order_details_order_desc_tv)
    TextView mDescTv;

    @BindView(R.id.fragment_order_details_final_price_tv)
    TextView mPriceTv;

    @BindView(R.id.fragment_order_details_spinner)
    MaterialSpinner mDelieverSpinner;

    @OnClick(R.id.fragment_order_details_save_fab)
    void onSaveClicked() {
        mPresenter.saveOrder();
        YourOrdersActivity.startActivity(getContext());
        getActivity().finish();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_details, container, false);

        ButterKnife.bind(this, view);
        mPresenter = new OrderDetailsFragmentPresenter(this);

        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Twoje zamówienie");
        }

        getBundledData();
        setupLayout();

        return view;
    }

    private void getBundledData() {
        mPresenter.setCurrentItem(((MenuItemInterface)getArguments().getSerializable(ORDERED_ITEM)));
    }

    private void setupLayout() {
        Glide.with(this).load(mPresenter.getMenuItem().getOriginalItem().getImageUrl()).centerCrop().into(mOrderIv);
        mDescTv.setText(mPresenter.getMenuItem().getDescription());
        mPriceTv.setText(new DecimalFormat("#.##").format(mPresenter.getMenuItem().getPrice()) + "zł");
        mDelieverSpinner.setItems("Odbiór w lokalu", "Dowóz");
        mDelieverSpinner.setOnItemSelectedListener(this);
    }

    private void showAddressDialog() {
        new MaterialDialog.Builder(getContext())
                .title("Twój adres")
                .positiveColorRes(R.color.accent)
                .negativeColorRes(R.color.accent)
                .negativeText("Anuluj")
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        mDelieverSpinner.setSelectedIndex(0);
                        dialog.dismiss();
                    }
                })
                .positiveText("Potwierdź")
                .input("Adres", "", new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {

                    }
                })
                .show();
    }

    @Override
    public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
        if (position == 1) {
            showAddressDialog();
        }
    }
}

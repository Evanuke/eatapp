package com.majstry.eatapp.fragments;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.dexafree.materialList.card.Card;
import com.dexafree.materialList.card.CardProvider;
import com.dexafree.materialList.view.MaterialListView;
import com.majstry.eatapp.R;
import com.majstry.eatapp.activities.OrderActivity;
import com.majstry.eatapp.base.BaseFragment;
import com.majstry.eatapp.models.interfaces.MenuItemInterface;
import com.majstry.eatapp.presenters.YourOrdersFragmentPresenter;

import java.text.DecimalFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YourOrdersFragment extends BaseFragment {

    private YourOrdersFragmentPresenter mPresenter;

    @BindView(R.id.fragment_your_orders_block_view)
    RelativeLayout mBlockRl;

    @BindView(R.id.fragment_your_orders_no_content_rl)
    RelativeLayout mNoContentRl;

    @BindView(R.id.fragment_your_orders_content_rl)
    RelativeLayout mContentRl;

    @BindView(R.id.material_listview)
    MaterialListView mOrdersMlv;

    @OnClick(R.id.fragment_your_orders_add_order)
    void onAddOrderClicked() {
        OrderActivity.startActivity(getContext());
        getActivity().finish();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_your_orders, container, false);

        ButterKnife.bind(this, view);

        mPresenter = new YourOrdersFragmentPresenter(this);

        return view;
    }

    public void onDataLoaded(ArrayList<MenuItemInterface> orders) {
        for (MenuItemInterface item : orders) {
            Card card = new Card.Builder(getContext())
                    .withProvider(new CardProvider())
                    .setLayout(R.layout.card_layout)
                    .setTitle(item.getDescription())
                    .setTitleColor(ContextCompat.getColor(getContext(), R.color.white))
                    .setDescription(new DecimalFormat("0.00").format(item.getPrice()) + "zł")
                    .setDrawable(item.getOriginalItem().getImageUrl())
                    .endConfig()
                    .build();

            mOrdersMlv.getAdapter().add(card);
        }
    }

    public RelativeLayout getBlockView() {
        return mBlockRl;
    }

    public RelativeLayout getNoContentView() {
        return mNoContentRl;
    }

    public RelativeLayout getDataView() {
        return mContentRl;
    }
}

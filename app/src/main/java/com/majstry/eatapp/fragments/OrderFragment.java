package com.majstry.eatapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.majstry.eatapp.R;
import com.majstry.eatapp.activities.OrderActivity;
import com.majstry.eatapp.adapters.IngredientsListAdapter;
import com.majstry.eatapp.base.BaseFragment;
import com.majstry.eatapp.presenters.OrderFragmentPresenter;
import com.majstry.eatapp.utils.snackbars.SnackbarUtil;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderFragment extends BaseFragment implements MaterialSpinner.OnItemSelectedListener {

    private OrderFragmentPresenter mPresenter;

    @BindView(R.id.fragment_order_spinner)
    MaterialSpinner mBasicMealSpinner;

    @BindView(R.id.fragment_order_order_desc_tv)
    TextView mOrderDescTv;

    @BindView(R.id.fragment_order_ingredients_lv)
    ListView mIngredientsLv;

    @BindView(R.id.fragment_order_final_price_tv)
    TextView mPriceTv;

    @OnClick(R.id.fragment_order_add_fab)
    void onAddIngredientClicked() {
        showIngredientChooseDialog();
    }

    @OnClick(R.id.fragment_order_save_fab)
    void onSaveClicked() {
        if (mPresenter.getUsedIngredients().size() > 0) {
            showConfirmationDialog();
        } else {
            SnackbarUtil.showErrorSnackbar("Musisz wybrać conajmniej jeden dodatkowy składnik!");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        ButterKnife.bind(this, view);
        mPresenter = new OrderFragmentPresenter(this);

        setupMenuSpinner();
        updateLayout();

        return view;
    }

    private void setupMenuSpinner() {
        mBasicMealSpinner.setItems(mPresenter.getAllMenuItems());
        mBasicMealSpinner.setOnItemSelectedListener(this);
        mBasicMealSpinner.setSelectedIndex(0);
        mPresenter.setSelectedMenuItemPosition(0);
    }

    private void updateLayout() {
        mOrderDescTv.setText(mPresenter.getMenuItem().getFinalDescription());
        mPriceTv.setText(new DecimalFormat("0.00").format(mPresenter.getMenuItem().getFinalPrice()) + "zł");

        IngredientsListAdapter adapter = new IngredientsListAdapter(getContext(), mPresenter.getUsedIngredients());
        mIngredientsLv.setAdapter(adapter);
        mIngredientsLv.setDivider(null);
    }

    private void showIngredientChooseDialog() {
        new MaterialDialog.Builder(getContext())
                .title("Wybierz dodatek")
                .positiveColorRes(R.color.accent)
                .negativeColorRes(R.color.accent)
                .negativeText("Anuluj")
                .items(mPresenter.getIngredients())
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View itemView, int position, CharSequence text) {
                        mPresenter.addIngredientFromPosition(position);
                        updateLayout();
                    }
                })
                .show();
    }

    private void showConfirmationDialog() {
        new MaterialDialog.Builder(getContext())
                .title("Twoje danie")
                .positiveColorRes(R.color.accent)
                .negativeColorRes(R.color.accent)
                .content("Czy jesteś pewien? Edycja danych będzie nie możliwa po zatwierdzeniu Twojego zamówienia.")
                .negativeText("Anuluj")
                .positiveText("Potwierdź")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        mPresenter.proceedToConfirmation();
                    }
                })
                .show();
    }

    @Override
    public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
        mPresenter.setSelectedMenuItemPosition(position);
        updateLayout();
    }
}

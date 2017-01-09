package com.majstry.eatapp.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.majstry.eatapp.MyApplication;
import com.majstry.eatapp.R;
import com.majstry.eatapp.base.BaseActivity;
import com.majstry.eatapp.models.SpecialOffer;
import com.majstry.eatapp.utils.snackbars.SnackbarUtil;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.DimenHolder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements Drawer.OnDrawerItemClickListener {

    private static final String START_WITH_INFO = "start_with_info";

    @BindView(R.id.activity_main_toolbar)
    Toolbar mToolbar;

    private Drawer mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        mToolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));

        setupNavigationDrawer();
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

        showInfoIfNeeded();
    }

    private void showInfoIfNeeded() {
        if (getIntent().getBooleanExtra(START_WITH_INFO, false)) {
            SnackbarUtil.showInfoSnackbar("Zamówienie zostało poprawnie złożone!");
        }
    }

    private void setupNavigationDrawer() {
        DrawerBuilder builder = new DrawerBuilder().withActivity(this).withToolbar(mToolbar);
        builder.withDrawerItems(generateDrawerItems());
        builder.withHeader(R.layout.nav_header);
        builder.withOnDrawerItemClickListener(this);
        mDrawer = builder.build();
        mDrawer.setSelectionAtPosition(-1, false);
    }

    private ArrayList<IDrawerItem> generateDrawerItems() {
        ArrayList<IDrawerItem> drawerItems = new ArrayList<>();

        drawerItems.add(new PrimaryDrawerItem().withName("Menu").withTag(new MenuActivity()).withIcon(R.drawable.ic_restaurant_menu_black_24dp));
        drawerItems.add(new PrimaryDrawerItem().withName("Własne zamówienie").withTag(new OrderActivity()).withIcon(R.drawable.ic_add_shopping_cart_black_24dp));
        drawerItems.add(new PrimaryDrawerItem().withName("Oceny").withTag(null).withIcon(R.drawable.ic_star_border_black_24dp));
        drawerItems.add(new PrimaryDrawerItem().withName("Promocje").withTag(new SpecialOffersActivity()).withIcon(R.drawable.ic_local_offer_black_24dp));
        drawerItems.add(new PrimaryDrawerItem().withName("Twoje zamówienia").withTag(new YourOrdersActivity()).withIcon(R.drawable.ic_shopping_cart_black_24dp));

        return drawerItems;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mDrawer != null) {
            mDrawer.setSelectionAtPosition(-1, false);
        }
    }

    @Override
    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
        Object tag = drawerItem.getTag();

        if (tag instanceof MenuActivity) {
            MenuActivity.startActivity(this);
        } else if (tag instanceof OrderActivity) {
            OrderActivity.startActivity(this);
        } else if (tag instanceof YourOrdersActivity) {
            YourOrdersActivity.startActivity(this);
        } else if (tag instanceof SpecialOffersActivity) {
            SpecialOffersActivity.startActivity(this);
        }

        return false;
    }
}

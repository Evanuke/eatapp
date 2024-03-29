package com.majstry.eatapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.majstry.eatapp.R;
import com.majstry.eatapp.base.BaseActivity;
import com.majstry.eatapp.base.BaseFragment;
import com.majstry.eatapp.fragments.OrderFragment;

public class OrderActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));


        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));

        if (getSupportActionBar() == null) {
            return;
        }

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        changeFragment(new OrderFragment());
    }

    public void changeFragment(BaseFragment baseFragment) {
        if (getSupportFragmentManager().getFragments() == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.activity_order_content_frame, baseFragment).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_order_content_frame, baseFragment).commit();
        }
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, OrderActivity.class);
        context.startActivity(intent);
    }

}

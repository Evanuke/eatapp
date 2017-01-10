package com.majstry.eatapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.majstry.eatapp.R;
import com.majstry.eatapp.base.BaseActivity;

public class RatingsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);
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
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, RatingsActivity.class);
        context.startActivity(intent);
    }

}

package com.majstry.eatapp;

import android.content.Context;

import com.majstry.eatapp.models.MenuItem;

import java.util.ArrayList;

public class DataStore {

    private Context mContext;

    private ArrayList<MenuItem> mMenuItems;

    public DataStore(Context context) {
        mContext = context;

        mMenuItems = new ArrayList<>();
    }

    public void prepareMockups() {
        MenuItem pizza = new MenuItem("Pizza szefa", "http://www.zajadam.pl/wp-content/uploads/2014/08/pizza-z-pomidorami-4-469x313.jpg", 13.5f, "Pieczarki, oliwki, podwójny ser, sos czosnkowy.");
        MenuItem dinner = new MenuItem("Zestaw Obiadowy", "http://crookedcreekguides.com/wp-content/uploads/2016/01/dinner-03.jpg", 27.99f, "Stek, sałatka warzywna, ziemniaki.");
        MenuItem homar = new MenuItem("Homar", "http://www.kuchniaplus.pl/img_files/nowy11/homar2.jpg", 44.50f, "Świeżo upieczony homar.");
        MenuItem salad = new MenuItem("Sałatka grecka", "http://www.codogara.pl/wp-content/uploads/2015/05/salatkagrecka3.jpg", 7.99f, "Sałatka grecka z świeżych składników. Oliwki, sałata, ser feta.");
        MenuItem meat = new MenuItem("Pieczeń", "http://plcdn.ar-cdn.com/hubcarousel/xlarge/video_roast_leg_lamb.jpg", 30f, "Pieczeń wołowa");

        mMenuItems.add(pizza);
        mMenuItems.add(dinner);
        mMenuItems.add(homar);
        mMenuItems.add(salad);
        mMenuItems.add(meat);
    }

    public ArrayList<MenuItem> getMenuItems() {
        return mMenuItems;
    }

}

package com.majstry.eatapp;

import android.content.Context;

import com.majstry.eatapp.models.MenuItem;
import com.majstry.eatapp.models.MenuItemDecorator;
import com.majstry.eatapp.models.interfaces.MenuItemInterface;

import java.util.ArrayList;

public class DataStore {

    private Context mContext;

    private ArrayList<MenuItem> mMenuItems;
    private ArrayList<MenuItemDecorator> mIngredients;
    private ArrayList<MenuItemInterface> mOrderedItems;

    public DataStore(Context context) {
        mContext = context;

        mMenuItems = new ArrayList<>();
        mIngredients = new ArrayList<>();
        mOrderedItems = new ArrayList<>();
    }

    public void prepareMockups() {
        MenuItem pizza = new MenuItem("Pizza szefa", "http://www.zajadam.pl/wp-content/uploads/2014/08/pizza-z-pomidorami-4-469x313.jpg", 13.5f, "Pieczarki, oliwki, podwójny ser, sos czosnkowy");
        MenuItem dinner = new MenuItem("Zestaw Obiadowy", "http://crookedcreekguides.com/wp-content/uploads/2016/01/dinner-03.jpg", 27.99f, "Pyszny zestaw obiadowy. Stek, sałatka warzywna, ziemniaki");
        MenuItem homar = new MenuItem("Homar", "http://www.kuchniaplus.pl/img_files/nowy11/homar2.jpg", 44.50f, "Świeżo upieczony homar");
        MenuItem salad = new MenuItem("Sałatka grecka", "http://www.codogara.pl/wp-content/uploads/2015/05/salatkagrecka3.jpg", 7.99f, "Sałatka grecka z świeżych składników. Oliwki, sałata, ser feta");
        MenuItem meat = new MenuItem("Pieczeń", "http://plcdn.ar-cdn.com/hubcarousel/xlarge/video_roast_leg_lamb.jpg", 30f, "Pieczeń wołowa z sosem");

        mMenuItems.add(pizza);
        mMenuItems.add(dinner);
        mMenuItems.add(homar);
        mMenuItems.add(salad);
        mMenuItems.add(meat);

        MenuItemDecorator fries = new MenuItemDecorator("Frytki", 3f);
        MenuItemDecorator olives = new MenuItemDecorator("Oliwki", 1.99f);
        MenuItemDecorator cheese = new MenuItemDecorator("Ser", 1.5f);
        MenuItemDecorator tea = new MenuItemDecorator("Herbata", 2.99f);

        mIngredients.add(fries);
        mIngredients.add(olives);
        mIngredients.add(cheese);
        mIngredients.add(tea);
    }

    public ArrayList<MenuItemInterface> getOrders() {
        return new ArrayList<>(mOrderedItems);
    }

    public ArrayList<MenuItem> getMenuItems() {
        return new ArrayList<>(mMenuItems);
    }

    public ArrayList<MenuItemDecorator> getIngredients() {
        return new ArrayList<>(mIngredients);
    }

    public void saveOrder(MenuItemInterface menuItem) {
        mOrderedItems.add(menuItem);
    }

}

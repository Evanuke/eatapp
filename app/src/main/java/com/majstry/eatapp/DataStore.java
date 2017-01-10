package com.majstry.eatapp;

import android.content.Context;
import android.support.v7.view.menu.MenuWrapperFactory;

import com.majstry.eatapp.models.MenuItem;
import com.majstry.eatapp.models.MenuItemDecorator;
import com.majstry.eatapp.models.News;
import com.majstry.eatapp.models.SpecialOffer;
import com.majstry.eatapp.models.interfaces.MenuItemInterface;

import java.util.ArrayList;

public class DataStore {

    private Context mContext;

    private ArrayList<MenuItem> mMenuItems;
    private ArrayList<MenuItemDecorator> mIngredients;
    private ArrayList<MenuItemInterface> mOrderedItems;
    private ArrayList<SpecialOffer> mSpecialOffers;
    private ArrayList<News> mNewses;

    public DataStore(Context context) {
        mContext = context;

        mMenuItems = new ArrayList<>();
        mIngredients = new ArrayList<>();
        mOrderedItems = new ArrayList<>();
        mSpecialOffers = new ArrayList<>();
        mNewses = new ArrayList<>();
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

        SpecialOffer soDinner = new SpecialOffer("Zestaw Obiadowy", 0.75f, false);
        SpecialOffer soMeat = new SpecialOffer("Pieczeń", 0.85f, false);

        mSpecialOffers.add(soDinner);
        mSpecialOffers.add(soMeat);

        News newPizza = new News("Sezonowa oferta - Pizza szefa!", "Tylko w tym tygodniu! Wyjątkowa oferta\nPizza Szefa według legendarnego przepisu.\nSprawdź menu!");
        News newIngredients = new News("Dodaliśmy nowe dodatki do zamówień", "Sprawdź! Dostępne tylko przez aplikację.");
        News newOrder = new News("Od Stycznia dowóz do domu!", "");

        mNewses.add(newPizza);
        mNewses.add(newIngredients);
        mNewses.add(newOrder);
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

    public ArrayList<SpecialOffer> getSpecialOffers() {
        return new ArrayList<>(mSpecialOffers);
    }

    public ArrayList<News> getNewses() {
        return new ArrayList<>(mNewses);
    }

    public void saveOrder(MenuItemInterface menuItem) {
        mOrderedItems.add(menuItem);
    }

    public void setDiscountMenuItem(MenuItem menuItem) {
        for (MenuItem m : mMenuItems) {
            if (m.equals(menuItem)) {
                int index = mMenuItems.indexOf(m);
                mMenuItems.set(index, menuItem);
            }
        }
    }

}

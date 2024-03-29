package com.majstry.eatapp.models;

import com.majstry.eatapp.models.interfaces.MenuItemInterface;

import java.text.DecimalFormat;

public class MenuItemDecorator implements MenuItemInterface {

    private MenuItemInterface menuItem;
    private String description;
    private float price;

    public MenuItemDecorator(String description, float price) {
        this.description = description;
        this.price = price;
    }

    public MenuItemInterface getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItemInterface menuItem) {
        this.menuItem = menuItem;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return menuItem.getDescription() + " + " + description;
    }

    @Override
    public float getPrice() {
        return menuItem.getPrice() + price;
    }

    @Override
    public MenuItem getOriginalItem() {
        return menuItem.getOriginalItem();
    }

    @Override
    public String toString() {
        return description + ", " + new DecimalFormat("0.00").format(price);
    }
}

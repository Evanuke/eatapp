package com.majstry.eatapp.models;

import com.majstry.eatapp.models.interfaces.MenuItemInterface;

import java.io.Serializable;
import java.text.DecimalFormat;

public class MenuItem implements MenuItemInterface, Serializable {

    private String name;
    private String imageUrl;
    private float price;
    private String description;

    public MenuItem(String name, String imageUrl, float price, String description) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getFinalDescription() {
        return description;
    }

    @Override
    public float getFinalPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ", " + new DecimalFormat("0.00").format(price) + "zł";
    }
}

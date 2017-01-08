package com.majstry.eatapp.models.interfaces;

import com.majstry.eatapp.models.MenuItem;

import java.io.Serializable;

public interface MenuItemInterface extends Serializable {

    String getDescription();
    float getPrice();
    MenuItem getOriginalItem();

}

package com.majstry.eatapp.models;

public class SpecialOffer {

    private String name;
    private float discount;
    private boolean isTaken;

    public SpecialOffer (String name, float discount, boolean isTaken) {
        this.name = name;
        this.discount = discount;
        this.isTaken = isTaken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }
}

package com.majstry.eatapp.models;

public class Rating {

    private String name;
    private int rating;
    private String imgUrl;

    public Rating(String name, int rating, String imgUrl) {
        this.name = name;
        this.rating = rating;
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

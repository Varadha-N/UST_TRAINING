package com.ShoppingCart;

public class ProductDetails
{
    private String title;
    private String brand;
    private float price;
    private float rating;

    public ProductDetails(String title, String brand, float price, float rating) {
        this.title = title;
        this.brand = brand;
        this.price = price;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

}

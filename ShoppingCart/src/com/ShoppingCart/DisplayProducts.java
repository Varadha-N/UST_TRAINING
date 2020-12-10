package com.ShoppingCart;

import java.io.Console;

public class DisplayProducts
{

    private FilterStore filters;

    public DisplayProducts(FilterStore filters)
    {
        this.filters = filters;
    }

    public void displayProducts()
    {
        String productName = ProductConsole.readString("Enter Product Name : ");
        String productBrand = ProductConsole.readString("Enter Product Brand: ");
        float product_minimum_price = (float) ProductConsole.getValues("Enter Product Minimum Price",0);
        float product_maximum_price = (float) ProductConsole.getValues("Enter Product Maximum Price",product_minimum_price);
        float productRating = (float) ProductConsole.getValues("Enter Product Rating (1-5)",1,5);
        filters.addFilter(productName,productBrand,product_minimum_price,product_maximum_price,productRating);
    }

}

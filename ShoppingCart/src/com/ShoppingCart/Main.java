package com.ShoppingCart;

public class Main {

    public static void main(String[] args)
    {
	// write your code here
        DisplayProducts display = new DisplayProducts(new FilterStore());
        display.displayProducts();

    }
}

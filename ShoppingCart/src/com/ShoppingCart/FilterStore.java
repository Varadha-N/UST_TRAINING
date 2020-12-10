package com.ShoppingCart;

import java.util.List;

public class FilterStore {

    static List<ProductDetails> products =  List.of(
            new ProductDetails("Kurta","Biba",2000f,4.8f),
            new ProductDetails("Kurta","Libas",1500f,4f),
            new ProductDetails("Kurta","Anmi",850f,3.8f),
            new ProductDetails("Jacket","Denim",800f,4.5f),
            new ProductDetails("Jacket","WildCraft",2550f,4.3f),
            new ProductDetails("Choclate","Cardbury Shorts Truffles",252f,4.5f),
            new ProductDetails("Choclate","Ferrero Rocher 24 Pcs Choclate Truffles",849f,4.5f),
            new ProductDetails("Choclate","Melody",150f,3.5f),
            new ProductDetails("Mobile","Samsung Galaxy F41",15_000f,4.3f),
            new ProductDetails("Mobile","POCO C3",7999f,4.3f),
            new ProductDetails("Mobile","One Plus Nord",26_000f,4.8f)
    );

    public void addFilter(String title,
                          String brand,
                          float priceMin,
                          float priceMax,
                          float rating
    ) {
        products.stream()
                .filter(m -> m.getTitle().toLowerCase().equals(title.toLowerCase()))
                .filter(m -> m.getBrand().toLowerCase().equals(brand.toLowerCase()))
                .filter(m -> m.getPrice() > priceMin)
                .filter(m -> m.getPrice()< priceMax)
                .filter(m -> m.getRating() >= rating)
                .forEach(m -> System.out.println(m.getTitle() +" : "+
                        m.getBrand()+" : "+
                        m.getPrice()+" : "+
                        m.getRating()));

    }

}

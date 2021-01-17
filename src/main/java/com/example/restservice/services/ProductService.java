package com.example.restservice.services;

import com.example.restservice.resources.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    public ArrayList<Product> getProducts(){
        ArrayList<Product> productsList = new ArrayList<>();
        // add sample products to the arraylist
        productsList.add(new Product(1, "Water Bottle"));
        productsList.add(new Product(2, "Pillow"));
        productsList.add(new Product(3, "Camping Tent"));
        productsList.add(new Product(4, "Blanket"));
        productsList.add(new Product(5, "Bear Spray"));

        return productsList;

    }
}

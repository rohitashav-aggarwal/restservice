package com.example.restservice.controllers;

import com.example.restservice.resources.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ProductController {

    private  ArrayList<Product> productsList;

    @GetMapping("/products")
    public List<Product> product (){
        productsList = new ArrayList<>();
        // add sample products to the arraylist
        productsList.add(new Product(1, "Water Bottle"));
        productsList.add(new Product(2, "Pillow"));
        productsList.add(new Product(3, "Camping Tent"));
        productsList.add(new Product(4, "Blanket"));
        productsList.add(new Product(5, "Bear Spray"));
        return productsList;
    }
}

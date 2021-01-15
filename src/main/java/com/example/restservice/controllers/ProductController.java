package com.example.restservice.controllers;

import com.example.restservice.resources.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ProductController {

    private final AtomicLong counter = new AtomicLong();
    private final ArrayList<Product> productsList = new ArrayList<>();

    @GetMapping("/products")
    public List<Product> product (){
        // add sample products to the arraylist
        productsList.add(new Product(counter.incrementAndGet(), "Water Bottle"));
        productsList.add(new Product(counter.incrementAndGet(), "Pillow"));
        productsList.add(new Product(counter.incrementAndGet(), "Camping Tent"));
        productsList.add(new Product(counter.incrementAndGet(), "Blanket"));
        productsList.add(new Product(counter.incrementAndGet(), "Bear Spray"));
        return productsList;
    }
}

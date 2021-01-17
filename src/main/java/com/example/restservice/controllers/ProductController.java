package com.example.restservice.controllers;

import com.example.restservice.resources.Product;
import com.example.restservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ArrayList<Product> getProducts(){

        return productService.getProducts();
    }
}

package com.example.restservice.resources;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;

@Resource
public class Product {
    private long id;

    private String name;

    public Product() {
    }

    public Product(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

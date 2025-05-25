package org.example.Problems.ecommerce;

import java.util.UUID;

public class Product {
    private String id;
    private String name;
    private String details;
    private double price;

    public Product(String name, String details, double price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.details = details;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

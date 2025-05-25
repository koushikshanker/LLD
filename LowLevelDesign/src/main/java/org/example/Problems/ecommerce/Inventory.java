package org.example.Problems.ecommerce;

import java.util.List;

public class Inventory {
    private String id;
    private List<Product> products;

    public Inventory(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product)
    {
        products.add(product);
    }

    public void removeProduct(Product product)
    {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

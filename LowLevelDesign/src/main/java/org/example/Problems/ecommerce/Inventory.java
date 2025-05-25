package org.example.Problems.ecommerce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventory {
    private final List<Product> products;

    public Inventory(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

    public synchronized void addProduct(Product product) {
        products.add(product);
    }

    public synchronized void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
}

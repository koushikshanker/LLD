package org.example.Problems.Ecommerce;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final Map<Product, Integer> products;

    public Cart() {
        this.products = new HashMap<>();
    }

    public Map<Product, Integer> getProducts() {
        return Collections.unmodifiableMap(products);
    }

    public void addProductsToCart(Product product, int quantity) {
        products.merge(product, quantity, Integer::sum);
    }

    public void removeProductFromCart(Product product) {
        products.remove(product);
    }

    public double getPriceOfCart() {
        return products.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }
}

package org.example.Problems.ecommerce;

import java.util.List;
import java.util.Map;

public class Cart {
    private String id;
    private Map<Product, Integer> products;

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public double getPriceOfCart()
    {
        double totalPrice = 0.0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            totalPrice += product.getPrice() * quantity;
        }
        return totalPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }


    public void addProductsToCart(Product product, Integer quantity) {
        products.put(product,quantity);
    }

    public void removeProductFromCart(Product product) {
        products.remove(product);
    }
}

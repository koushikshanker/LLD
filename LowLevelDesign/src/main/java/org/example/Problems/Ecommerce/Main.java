package org.example.Problems.Ecommerce;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product iphone = new Product("iPhone", "iPhone 16", 100010);
        Product samsung = new Product("Samsung", "Mini", 70000);

        User user = new User("Ramesh", "9908", "ramesh@gmail.com");

        DeliveryPerson suresh = new DeliveryPerson("Suresh", "9918", "suresh@gmail.com");
        DeliveryPerson somesh = new DeliveryPerson("Somesh", "9919", "somesh@gmail.com");

        EcommerceService ecommerceService = new EcommerceService(List.of(iphone, samsung));
        ecommerceService.getDeliveryService().addDeliveryPerson(suresh);
        ecommerceService.getDeliveryService().addDeliveryPerson(somesh);

        System.out.println("User lands on home page and searches for a product");
        List<Product> searchResults = ecommerceService.searchProduct("iphone");

        if (searchResults.isEmpty()) {
            System.out.println("No products found");
            return;
        }

        System.out.println("User chose a product from list of products");
        Product selectedProduct = searchResults.get(0);

        System.out.println("Adding products to cart");
        Cart cart = ecommerceService.createCart();
        ecommerceService.addProductToCart(cart, selectedProduct, 2);

        System.out.println("User checks out from cart");
        Order order = ecommerceService.checkoutCart(user, cart);

        System.out.println("User places an order");
        order = ecommerceService.placeOrder(order);

        System.out.println("Order status: " + order.getOrderStatus());

        // Simulate delivery
        DeliveryService deliveryService = ecommerceService.getDeliveryService();
        deliveryService.startDelivery(order);

        System.out.println("Delivery started for order: " + order.getId());

        deliveryService.completeDelivery(order);

        System.out.println("Delivery completed for order: " + order.getId());
        System.out.println("Final order status: " + order.getOrderStatus());
    }
}

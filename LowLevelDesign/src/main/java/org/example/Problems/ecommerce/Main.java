package org.example.Problems.ecommerce;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Product product = new Product("iphone","iphone 16",100010);
        Product product2 = new Product("samsung","mini",70000);

        User user = new User("ramesh","9908","ramesh@gmail.com");

        DeliveryPerson deliveryPerson = new DeliveryPerson("suresh","9918","suresh@gmail.com");
        DeliveryPerson deliveryPerson2 = new DeliveryPerson("somesh","9918","somesh@gmail.com");

        EcommerceService ecommerceService = new EcommerceService(List.of(product,product2));

        ecommerceService.getDeliveryService().setDeliveryPersonList(List.of(deliveryPerson,deliveryPerson2));

        System.out.println("User lands on home page and search for a product");
        System.out.println("----------------------------------------------------");
        List<Product> searchResults = ecommerceService.searchProduct("iphone");

        System.out.println("User picks first product from search results");
        System.out.println("----------------------------------------------------");
        Product userSelectedProduct = searchResults.getFirst();

        System.out.println("User add 2 products to car");
        System.out.println("----------------------------------------------------");
        Map<Product, Integer> orderProducts = new HashMap<>();
        orderProducts.put(product,1);
        Cart cart = ecommerceService.addProductsToCart(orderProducts);

        System.out.println("User checks out from cart");
        System.out.println("----------------------------------------------------");
        Order order = ecommerceService.checkoutCart(user, cart);

        System.out.println("User places an order");
        System.out.println("----------------------------------------------------");
        order = ecommerceService.placeOrder(order);


        System.out.println("A delivery person is assigned once the order is placed");
        System.out.println("----------------------------------------------------");
        DeliveryPerson deliveryPerson1 = null;
        if(order.getOrderStatus()==OrderStatus.COMPLETED)
        {
            deliveryPerson1 = ecommerceService.getDeliveryService().assignDeliveryPerson(order.getDeliveryDetails());
            deliveryPerson1.setDeliveryPersonStatus(DeliveryPersonStatus.OCCUPIED);
        }

        System.out.println("The delivery person delivers the order");
        System.out.println("----------------------------------------------------");
        if(deliveryPerson1!=null)
        {
            deliveryPerson1.setDeliveryPersonStatus(DeliveryPersonStatus.AVAILABLE);
            order.setOrderStatus(OrderStatus.COMPLETED);
        }
    }
}

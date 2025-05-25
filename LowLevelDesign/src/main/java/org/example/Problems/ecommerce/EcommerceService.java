package org.example.Problems.ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class EcommerceService {
    DeliveryService deliveryService;
    EcommerceService instance;
    Inventory inventory;
    Cart cart;
    public EcommerceService(List<Product> products)
    {
        this.deliveryService = new DeliveryService();
        this.inventory = new Inventory(products);

    }

    public Inventory getInventory() {
        return inventory;
    }

    public Cart addProductsToCart(Map<Product, Integer> products)
    {
        cart = new Cart(products);
        return cart;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public DeliveryService getDeliveryService() {
        return deliveryService;
    }

    public void setDeliveryService(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }


    public List<Product> searchProduct(String productName)
    {
        List<Product> searchResults = new ArrayList<>();
        for(Product product:this.inventory.getProducts())
        {
            if(Objects.equals(product.getName(), productName))
            {
                searchResults.add(product);
            }
        }
        return searchResults;
    }

    public Order checkoutCart(User user, Cart cart)
    {
        return new Order(user,cart.getProducts());
    }

    public Order placeOrder(Order order)
    {
            //payment done
            order.setOrderStatus(OrderStatus.COMPLETED);
            return order;
    }
    public void cancelOrder(Order order)
    {

    }
    public void returnOrder(Order order)
    {

    }
    public void completeOrder(Order order)
    {

    }

}

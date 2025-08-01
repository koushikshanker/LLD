package org.example.Problems.KFoodDeliveryService.order;

import org.example.Problems.KFoodDeliveryService.MenuItem;

public class OrderItem {
    private final MenuItem menuItem;
    private final int quantity;

    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }
}

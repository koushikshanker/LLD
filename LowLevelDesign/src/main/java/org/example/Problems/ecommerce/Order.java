package org.example.Problems.ecommerce;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Order {
    private String id;
    private User user;
    private OrderStatus orderStatus;
    private Map<Product, Integer> productList;
    private PaymentStatus paymentStatus;
    private String deliveryDetails;
    private double orderValue;

    public Order(User user, Map<Product, Integer> productList) {
        this.id = UUID.randomUUID().toString();
        this.user = user;
        this.productList = productList;
        this.orderStatus = OrderStatus.IN_PROGRESS;
        this.paymentStatus = PaymentStatus.INITIATED;
        this.deliveryDetails = null;
        this.orderValue = getOrderValue();
    }

    public String getDeliveryDetails() {
        return deliveryDetails;
    }

    public void setDeliveryDetails(String deliveryDetails) {
        this.deliveryDetails = deliveryDetails;
    }

    public double getOrderValue() {
        double totalPrice = 0.0;
        for (Map.Entry<Product, Integer> entry : productList.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            totalPrice += product.getPrice() * quantity;
        }
        return totalPrice;
    }

    public void setOrderValue(double orderValue) {
        this.orderValue = orderValue;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Map<Product,Integer> getProductList() {
        return productList;
    }

    public void setProductList(Map<Product,Integer> productList) {
        this.productList = productList;
    }
}

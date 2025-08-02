package org.example.Problems.Ecommerce;

import java.util.Map;
import java.util.UUID;

public class Order {
    private final String id;
    private final User user;
    private final Map<Product, Integer> productList;  // Immutable once order placed
    private OrderStatus orderStatus;
    private PaymentStatus paymentStatus;
    private DeliveryInfo deliveryInfo;
    private double orderValue;

    public Order(User user, Map<Product, Integer> productList) {
        this.id = UUID.randomUUID().toString();
        this.user = user;
        this.productList = Map.copyOf(productList);
        this.orderStatus = OrderStatus.IN_PROGRESS;
        this.paymentStatus = PaymentStatus.INITIATED;
        this.deliveryInfo = null;
        this.orderValue = calculateOrderValue();
    }

    private double calculateOrderValue() {
        return productList.entrySet().stream()
                .mapToDouble(e -> e.getKey().getPrice() * e.getValue())
                .sum();
    }

    // Getters and setters

    public String getId() { return id; }
    public User getUser() { return user; }
    public Map<Product, Integer> getProductList() { return productList; }

    public OrderStatus getOrderStatus() { return orderStatus; }
    public void setOrderStatus(OrderStatus orderStatus) { this.orderStatus = orderStatus; }

    public PaymentStatus getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(PaymentStatus paymentStatus) { this.paymentStatus = paymentStatus; }

    public DeliveryInfo getDeliveryInfo() { return deliveryInfo; }
    public void setDeliveryInfo(DeliveryInfo deliveryInfo) { this.deliveryInfo = deliveryInfo; }

    public double getOrderValue() { return orderValue; }
}

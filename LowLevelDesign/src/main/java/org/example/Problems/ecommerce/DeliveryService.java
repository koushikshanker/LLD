package org.example.Problems.ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeliveryService {
    private final List<DeliveryPerson> deliveryPersons;

    public DeliveryService() {
        this.deliveryPersons = new ArrayList<>();
    }

    public synchronized void addDeliveryPerson(DeliveryPerson dp) {
        deliveryPersons.add(dp);
    }

    public synchronized DeliveryPerson assignDeliveryPerson() {
        Optional<DeliveryPerson> availablePerson = deliveryPersons.stream()
                .filter(dp -> dp.getStatus() == DeliveryPersonStatus.AVAILABLE)
                .findFirst();
        if (availablePerson.isPresent()) {
            DeliveryPerson dp = availablePerson.get();
            dp.setStatus(DeliveryPersonStatus.OCCUPIED);
            return dp;
        }
        throw new IllegalStateException("No delivery person available");
    }

    public void startDelivery(Order order) {
        System.out.println("Started delivery");
        order.setOrderStatus(OrderStatus.IN_DELIVERY);
    }

    public void completeDelivery(Order order) {
        System.out.println("Order delivered");
        order.setOrderStatus(OrderStatus.DELIVERED);
        if (order.getDeliveryInfo() != null) {
            // Free the delivery person
            // Assuming we can get DeliveryPerson from DeliveryInfo (extend model if needed)
        }
    }

    public void cancelDelivery(Order order) {
        order.setOrderStatus(OrderStatus.CANCELLED);
    }

    public void returnDelivery(Order order) {
        order.setOrderStatus(OrderStatus.RETURNED);
    }

    public List<DeliveryPerson> getDeliveryPersons() {
        return List.copyOf(deliveryPersons);
    }
}

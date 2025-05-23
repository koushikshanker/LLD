package org.example.Problems.AmazonLocker;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Strategy class to assign a delivery person for a locker item based on location or other criteria.
 */
public class AssignDeliveryPersonStrategy {
    private final List<DeliveryPerson> deliveryPersonList;

    public AssignDeliveryPersonStrategy() {
        this.deliveryPersonList = new ArrayList<>();
    }

    /**
     * Adds a delivery person to the pool.
     */
    public void addDeliveryPerson(DeliveryPerson deliveryPerson) {
        if (deliveryPerson == null) {
            throw new IllegalArgumentException("DeliveryPerson cannot be null");
        }
        deliveryPersonList.add(deliveryPerson);
    }

    /**
     * Retrieves a delivery person to assign based on locker item and location.
     * Currently, this method returns the first available delivery person.
     * TODO: Implement real strategy considering load, location, availability.
     *
     * @param lockerItem the locker item to deliver
     * @param location the delivery location
     * @return assigned DeliveryPerson
     * @throws NoSuchElementException if no delivery person is available
     */
    public DeliveryPerson getDeliveryPerson(LockerItem lockerItem, String location) {
        return deliveryPersonList.stream()
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No delivery person available"));
    }
}

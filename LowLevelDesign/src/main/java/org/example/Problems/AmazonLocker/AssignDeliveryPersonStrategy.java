package org.example.Problems.AmazonLocker;

import java.util.ArrayList;
import java.util.List;

public class AssignDeliveryPersonStrategy {
    List<DeliveryPerson> deliveryPersonList;

    public AssignDeliveryPersonStrategy()
    {
        this.deliveryPersonList = new ArrayList<>();
    }

    public void addDeliveryPerson(DeliveryPerson deliveryPerson)
    {
        deliveryPersonList.add(deliveryPerson);
    }
    public DeliveryPerson getDeliveryPerson(LockerItem lockerItem, String loc)
    {
        // Todo, implement a strategy to get a delivery person
        return deliveryPersonList.get(0);
    }
}

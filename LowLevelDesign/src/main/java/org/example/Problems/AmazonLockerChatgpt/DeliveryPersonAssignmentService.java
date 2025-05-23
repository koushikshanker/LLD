package org.example.Problems.AmazonLockerChatgpt;

import java.util.List;

public class DeliveryPersonAssignmentService {
    private List<DeliveryPerson> deliveryPeople;

    public DeliveryPersonAssignmentService(List<DeliveryPerson> deliveryPeople) {
        this.deliveryPeople = deliveryPeople;
    }

    public DeliveryPerson assignDeliveryPerson(String location) {
        for (DeliveryPerson dp : deliveryPeople) {
            if (dp.isAvailable() && dp.getLocation().equals(location))
            {
                System.out.println("Assigning a delivery person");
                System.out.println("------------------------------");
                return dp;
            }

        }
        return null;
    }
}


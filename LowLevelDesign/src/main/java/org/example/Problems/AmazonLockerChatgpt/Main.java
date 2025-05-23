package org.example.Problems.AmazonLockerChatgpt;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Setup lockers and slots
        List<Slot> slots1 = Arrays.asList(new Slot("S1", SlotSize.M), new Slot("S2", SlotSize.L));
        List<Slot> slots2 = Arrays.asList(new Slot("S3", SlotSize.M), new Slot("S4", SlotSize.XL));
        Locker locker1 = new Locker("L1", "Seattle", slots1);
        Locker locker2 = new Locker("L2", "Seattle", slots2);

        List<Locker> lockers = Arrays.asList(locker1, locker2);

        // Setup delivery people
        DeliveryPerson dp1 = new DeliveryPerson("DP1", "Alice", "alice@dp.com", "Seattle");
        DeliveryPerson dp2 = new DeliveryPerson("DP2", "Bob", "bob@dp.com", "Seattle");
        List<DeliveryPerson> deliveryPeople = Arrays.asList(dp1, dp2);

        // Setup users and items
        User user = new User("U1", "John", "john@example.com", "Seattle");
        Item item = new Item("I1", "Smartphone", SlotSize.M);

        // Locker system instance
        LockerSystem system = new LockerSystem(lockers, deliveryPeople);

        // Order processing
        Slot assignedSlot = system.processOrder(user, item);

        // Delivery person delivers item
        if (assignedSlot != null) {
            system.deliverItem(assignedSlot, assignedSlot.getOtp(), item, user);
        }

        // User collects item
        if (assignedSlot != null) {
            system.collectItem(assignedSlot, assignedSlot.getOtp());
        }

        // User initiates return
        system.returnItem(user, item);

        // Assume slot is reassigned same as before for return
        if (assignedSlot != null) {
            system.processReturn(assignedSlot, assignedSlot.getOtp(), item);
            system.pickupReturn(assignedSlot, assignedSlot.getOtp());
        }
    }
}


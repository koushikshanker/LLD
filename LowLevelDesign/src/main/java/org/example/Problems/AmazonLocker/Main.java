package org.example.Problems.AmazonLocker;

public class Main {

    public static void main(String[] args) {
        // Create lockers and add slots
        Locker locker1 = new Locker(1, "HydLocker", "HYDERABAD");
        locker1.addSlot(new Slot(1, "Slot1", "L"));
        locker1.addSlot(new Slot(2, "Slot2", "M"));

        Locker locker2 = new Locker(2, "BlrLocker", "BANGALORE");
        locker2.addSlot(new Slot(3, "Slot3", "S"));
        locker2.addSlot(new Slot(4, "Slot4", "L"));

        // Setup LockerStrategyService and add lockers
        LockerStrategyService lockerStrategyService = new LockerStrategyService();
        lockerStrategyService.addLocker(locker1);
        lockerStrategyService.addLocker(locker2);

        // Setup OTP generation and notification services
        OtpGenerationService otpGenerationService = new OtpGenerationService();
        NotificationService notificationService = new NotificationService();

        // Setup delivery persons and assign strategy
        AssignDeliveryPersonStrategy assignDeliveryPersonStrategy = new AssignDeliveryPersonStrategy();
        assignDeliveryPersonStrategy.addDeliveryPerson(new DeliveryPerson(1, "Suresh", "9901"));
        assignDeliveryPersonStrategy.addDeliveryPerson(new DeliveryPerson(2, "Raju", "9902"));

        // Instantiate the AmazonLockerService with dependencies
        AmazonLockerService lockerService = new AmazonLockerService(
                lockerStrategyService,
                otpGenerationService,
                assignDeliveryPersonStrategy,
                notificationService
        );

        // Create a user and a locker item
        User user = new User(1, "Ramesh", "9908");
        LockerItem item = new LockerItem(1, "Mobile Phone");

        // User places an order for locker item at Hyderabad location
        lockerService.userOrdersLockerItem(user, item, "HYDERABAD");

        // Simulate delivery person delivering the item to locker
        Locker assignedLocker = item.getLocker();
        Slot assignedSlot = item.getSlot();
        DeliveryPerson assignedDeliveryPerson = assignDeliveryPersonStrategy.getDeliveryPerson(item, "HYDERABAD");
        String otpForDelivery = assignedSlot.getOtp();

        lockerService.itemDeliveredToLocker(assignedDeliveryPerson, user, assignedLocker, item, assignedSlot, otpForDelivery);

        // Simulate user picking up the item from locker
        lockerService.userPicksOrderFromLocker(user, assignedLocker, assignedSlot, assignedSlot.getOtp());

        // Simulate user initiating a return
        lockerService.userReturnOrder(user, "HYDERABAD", item);

        // Simulate delivery person picking returned item from locker
        String otpForPickup = assignedSlot.getOtp();
        lockerService.deliveryPersonPicksOrderFromLocker(assignedDeliveryPerson, assignedLocker, assignedSlot, otpForPickup);
    }
}

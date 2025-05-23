package org.example.Problems.AmazonLocker;

import java.util.Objects;

/**
 * Core service class for managing Amazon Locker operations.
 */
public class AmazonLockerService {

    private final LockerStrategyService lockerStrategyService;
    private final OtpGenerationService otpGenerationService;
    private final AssignDeliveryPersonStrategy assignDeliveryPersonStrategy;
    private final NotificationService notificationService;

    public AmazonLockerService(
            LockerStrategyService lockerStrategyService,
            OtpGenerationService otpGenerationService,
            AssignDeliveryPersonStrategy assignDeliveryPersonStrategy,
            NotificationService notificationService
    ) {
        this.lockerStrategyService = lockerStrategyService;
        this.otpGenerationService = otpGenerationService;
        this.assignDeliveryPersonStrategy = assignDeliveryPersonStrategy;
        this.notificationService = notificationService;
    }

    /**
     * User places an order to store an item in locker.
     */
    public void userOrdersLockerItem(User user, LockerItem lockerItem, String location) {
        System.out.println("User orders an item");
        System.out.println("--------------------------------");

        Locker locker = lockerStrategyService.getLocker();
        if (locker == null) {
            throw new RuntimeException("No locker found at location: " + location);
        }

        Slot slot = locker.getFreeSlot();  // You might want a better strategy here
        lockerItem.setLocker(locker);
        lockerItem.setSlot(slot);

        String otp = otpGenerationService.generateOtp();

        DeliveryPerson deliveryPerson = assignDeliveryPersonStrategy.getDeliveryPerson(lockerItem, location);
        slot.setOtp(otp);

        notificationService.notifyUser(deliveryPerson, slot, otp);

        System.out.println("Delivery person assigned and notified.");
    }

    /**
     * Delivery person delivers item to locker slot.
     */
    public void itemDeliveredToLocker(DeliveryPerson deliveryPerson,
                                      User user, Locker locker, LockerItem lockerItem, Slot slot, String otp) {
        if (lockerItem.getLocker() != locker || !Objects.equals(slot.getOtp(), otp)) {
            throw new RuntimeException("Invalid locker or OTP");
        }

        System.out.println("Locker item delivered to locker: " + locker.getName());
        slot.setLockerItem(lockerItem);
        slot.setStatus(SlotStatus.OCCUPIED);

        // Notify user to pick item
        String userOtp = otpGenerationService.generateOtp();
        slot.setOtp(userOtp);

        notificationService.notifyUser(user, slot, userOtp);
    }

    /**
     * User picks the order from locker slot.
     */
    public void userPicksOrderFromLocker(User user, Locker locker, Slot slot, String otp) {
        if (!Objects.equals(slot.getOtp(), otp)) {
            throw new RuntimeException("Invalid OTP for user pickup");
        }

        System.out.println("User picked item from locker");
        slot.setStatus(SlotStatus.FREE);
        slot.setLockerItem(null);
    }

    /**
     * User initiates return of an item.
     */
    public void userReturnOrder(User user, String location, LockerItem lockerItem) {
        System.out.println("User returned order to locker");
        Locker locker = lockerStrategyService.getLocker();
        Slot slot = locker.getFreeSlot();

        lockerItem.setLocker(locker);
        lockerItem.setSlot(slot);

        String otp = otpGenerationService.generateOtp();
        slot.setOtp(otp);

        notificationService.notifyUser(user, slot, otp);

        itemDeliveredToLocker(null, user, locker, lockerItem, slot, otp); // DeliveryPerson can be null here if you want

        DeliveryPerson deliveryPerson = assignDeliveryPersonStrategy.getDeliveryPerson(lockerItem, location);
        notificationService.notifyUser(deliveryPerson, slot, otp);
    }

    /**
     * Delivery person picks item from locker after return.
     */
    public void deliveryPersonPicksOrderFromLocker(DeliveryPerson deliveryPerson, Locker locker, Slot slot, String otp) {
        if (!Objects.equals(slot.getOtp(), otp)) {
            throw new RuntimeException("Invalid OTP for delivery person pickup");
        }

        System.out.println("Delivery person picked item from locker");
        slot.setStatus(SlotStatus.FREE);
        slot.setLockerItem(null);
    }
}

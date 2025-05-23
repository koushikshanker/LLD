package org.example.Problems.AmazonLockerChatgpt;

import java.util.List;

public class LockerSystem {
    private LockerAssignmentService lockerAssignmentService;
    private SlotAssignmentService slotAssignmentService;
    private DeliveryPersonAssignmentService deliveryPersonAssignmentService;
    private OTPService otpService;
    private NotificationService notificationService;

    public LockerSystem(List<Locker> lockers, List<DeliveryPerson> deliveryPeople) {
        this.lockerAssignmentService = new LockerAssignmentService(lockers);
        this.slotAssignmentService = new SlotAssignmentService();
        this.deliveryPersonAssignmentService = new DeliveryPersonAssignmentService(deliveryPeople);
        this.otpService = new OTPService();
        this.notificationService = new NotificationService();
    }

    public Slot processOrder(User user, Item item) {
        System.out.println("User ordered an item");
        System.out.println("------------------------------");
        Locker locker = lockerAssignmentService.assignLocker(user.getLocation());

        if (locker == null) return null;

        Slot slot = slotAssignmentService.assignSlot(locker, item.getSize());

        if (slot == null)
            return null;

        String otp = otpService.generateOtp();
        slot.reserve(otp);

        DeliveryPerson dp = deliveryPersonAssignmentService.assignDeliveryPerson(user.getLocation());
        if (dp == null) return null;

        dp.setAvailable(false);


        notificationService.notifyDeliveryPerson(dp, "Deliver item " + item.getDescription() + " to locker " + locker.getId() + ", slot " + slot.getId() + " with OTP: " + otp);
        notificationService.notifyUser(user, "Your item will be delivered to locker " + locker.getId() + ", slot " + slot.getId() + ". OTP: " + otp);

        return slot;
    }

    public boolean deliverItem(Slot slot, String otp, Item item, User user) {
        System.out.println("Delivery person delivers item to locker");
        System.out.println("------------------------------");
        if (slot != null && slot.validateOtp(otp) && slot.getStatus() == SlotStatus.RESERVED) {
            System.out.println("Validating otp and checking status when item is delivered to slot");
            System.out.println("------------------------------");
            slot.occupy(item);

            // Notify the user after successful delivery
            notificationService.notifyUser(user, "Your item has been delivered to locker "
                    + slot.getId() + ". Use OTP: " + otp + " to collect your item.");

            return true;
        }
        return false;
    }


        public boolean collectItem(Slot slot, String otp) {
            if (slot != null && slot.validateOtp(otp) && slot.getStatus() == SlotStatus.OCCUPIED) {
                System.out.println("Validating otp and checking status when item collected from slot");
                System.out.println("------------------------------");
                slot.free();
                return true;
            }
            return false;
        }

        public boolean returnItem(User user, Item item) {
            System.out.println("User initiated a return");
            System.out.println("------------------------------");
            Locker locker = lockerAssignmentService.assignLocker(user.getLocation());
            if (locker == null) return false;

            Slot slot = slotAssignmentService.assignSlot(locker, item.getSize());
            if (slot == null) return false;

            String otp = otpService.generateOtp();
            slot.reserve(otp);

            notificationService.notifyUser(user, "Return your item to locker " + locker.getId() + ", slot " + slot.getId() + ". OTP: " + otp);
            return true;
        }

        public boolean processReturn(Slot slot, String otp, Item item) {
            if (slot != null && slot.validateOtp(otp) && slot.getStatus() == SlotStatus.RESERVED) {
                System.out.println("Validating otp and checking status when item is returned to slot");
                System.out.println("------------------------------");
                slot.occupy(item);
                return true;
            }
            return false;
        }

        public boolean pickupReturn(Slot slot, String otp) {
            if (slot != null && slot.validateOtp(otp) && slot.getStatus() == SlotStatus.OCCUPIED) {
                System.out.println("Validating otp and checking status when item is picked from slot");
                System.out.println("------------------------------");
                slot.free();
                return true;
            }
            return false;
        }
    }

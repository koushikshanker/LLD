package org.example.Problems.AmazonLocker;

/**
 * Service responsible for sending notifications to users and delivery personnel.
 */
public class NotificationService {

    /**
     * Notify a user with OTP and locker details.
     *
     * @param user The user to notify.
     * @param slot The locker slot assigned.
     * @param otp  The OTP to access the locker.
     */
    public void notifyUser(User user, Slot slot, String otp) {
        // Simulate sending notification (e.g., SMS, email)
        System.out.printf("Notification sent to User %s (Contact: %s): Your OTP for slot %s is %s%n",
                user.getName(), user.getContact(), slot.getName(), otp);
    }

    /**
     * Notify a delivery person with OTP and locker details.
     *
     * @param deliveryPerson The delivery person to notify.
     * @param slot The locker slot assigned.
     * @param otp  The OTP to access the locker.
     */
    public void notifyUser(DeliveryPerson deliveryPerson, Slot slot, String otp) {
        // Simulate sending notification (e.g., SMS, email)
        System.out.printf("Notification sent to DeliveryPerson %s (Contact: %s): Your OTP for slot %s is %s%n",
                deliveryPerson.getName(), deliveryPerson.getContact(), slot.getName(), otp);
    }
}

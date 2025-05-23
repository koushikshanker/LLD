package org.example.Problems.AmazonLockerChatgpt;

public class NotificationService {
    public void notifyUser(User user, String message) {
        System.out.println("[User Notification to " + user.getEmail() + "]: " + message);
        System.out.println("------------------------------");
    }

    public void notifyDeliveryPerson(DeliveryPerson dp, String message) {
        System.out.println("[Delivery Notification to " + dp.getEmail() + "]: " + message);
        System.out.println("------------------------------");
    }
}

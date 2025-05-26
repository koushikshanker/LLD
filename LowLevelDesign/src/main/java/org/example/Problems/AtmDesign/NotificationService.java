package org.example.Problems.AtmDesign;

public class NotificationService {
    public NotificationService(User user)
    {

    }
    public void sendNotification(User user, String message)
    {
        System.out.println(user.getName()+" "+message);
    }
}

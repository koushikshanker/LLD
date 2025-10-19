package org.example.Problems.MeetingScheduler;

public class UserObserver {
    private User user;

    public UserObserver(User user)
    {
        this.user = user;
    }

    public void update(String message)
    {
        System.out.println("Notify "+user.getName()+" about message");
    }
}

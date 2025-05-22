package org.example.Problems.MeetingScheduler;

public class UserObserver implements Observer{

    private final User user;
    public UserObserver(User user)
    {
        this.user = user;
    }

    @Override
    public void update(String message) {
        System.out.println("Notify "+user.getEmail()+": "+message);
    }
}

package org.example.Problems.MeetingScheduler;

import java.util.ArrayList;
import java.util.List;

public class NotificationSubject {
    private List<UserObserver> participants = new ArrayList<>();

    public void notifyAll(List<User> userList, String message)
    {
        for(User user:userList)
        {
            participants.add( new UserObserver(user));
        }

        for(UserObserver user:participants)
        {
            user.update(message);
        }
    }
}

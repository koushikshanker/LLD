package org.example.Problems.MeetingScheduler;

import java.util.ArrayList;
import java.util.List;

public class NotificationSubject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer)
    {
        observers.add(observer);
    }

    public void notifyAll(String message)
    {
        for(Observer observer:observers)
        {
            observer.update(message);
        }
    }

}

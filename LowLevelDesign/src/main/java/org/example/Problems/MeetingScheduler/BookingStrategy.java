package org.example.Problems.MeetingScheduler;


public interface BookingStrategy {
    MeetingRoom getMeetingRoom(Interval interval, int capacity);
}

package org.example.Problems.KMeetingScheduler.BookingStrategy;

import org.example.Problems.KMeetingScheduler.Interval;
import org.example.Problems.KMeetingScheduler.MeetingRoom;

import java.util.List;

public interface BookingStrategy {
    MeetingRoom findAvailableRoom(List<MeetingRoom> rooms, Interval interval, int capacity);
}

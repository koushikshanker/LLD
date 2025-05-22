package org.example.Problems.MeetingScheduler.BookingStrategy;

import org.example.Problems.MeetingScheduler.Interval;
import org.example.Problems.MeetingScheduler.MeetingRoom;

import java.util.List;

public interface BookingStrategy {
    MeetingRoom findAvailableRoom(List<MeetingRoom> rooms, Interval interval, int capacity);
}

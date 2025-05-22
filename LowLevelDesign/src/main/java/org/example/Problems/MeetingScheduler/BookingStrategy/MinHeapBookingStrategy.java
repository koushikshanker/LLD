package org.example.Problems.MeetingScheduler.BookingStrategy;

import org.example.Problems.MeetingScheduler.Interval;
import org.example.Problems.MeetingScheduler.MeetingRoom;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinHeapBookingStrategy implements BookingStrategy {

    @Override
    public MeetingRoom findAvailableRoom(List<MeetingRoom> rooms, Interval interval, int capacity) {
        PriorityQueue<MeetingRoom> pq = new PriorityQueue<>(Comparator.comparingInt(r -> r.getMeetings().size()));

        for (MeetingRoom room : rooms) {
            if (room.getCapacity() >= capacity && room.isAvailable(interval)) {
                pq.add(room);
            }
        }

        return pq.poll(); // returns null if no rooms were added
    }
}
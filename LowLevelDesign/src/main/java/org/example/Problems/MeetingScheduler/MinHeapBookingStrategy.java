package org.example.Problems.MeetingScheduler;

import java.util.PriorityQueue;

import java.util.*;

public class MinHeapBookingStrategy implements BookingStrategy {

    private PriorityQueue<MeetingRoom> roomQueue;

    public MinHeapBookingStrategy(List<MeetingRoom> rooms)
    {
        Comparator<MeetingRoom> cmp = (a, b) -> a.getMeetings().size() - b.getMeetings().size();
        roomQueue = new PriorityQueue<>(cmp);
        roomQueue.addAll(rooms);
    }

    @Override
    public MeetingRoom getMeetingRoom(Interval interval, int capacity)
    {
        List<MeetingRoom> temp = new ArrayList<>();
        MeetingRoom selected = null;

        while (!roomQueue.isEmpty())
        {
            MeetingRoom room = roomQueue.poll();

            if (room.getCapacity() >= capacity && room.isAvailable(interval))
            {
                selected = room;
                break;
            }

            temp.add(room);
        }

        roomQueue.addAll(temp);

        return selected;
    }


    public void updateRoom(MeetingRoom room)
    {
        roomQueue.remove(room);
        roomQueue.add(room);
    }
}


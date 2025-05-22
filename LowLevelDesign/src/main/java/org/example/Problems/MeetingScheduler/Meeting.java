package org.example.Problems.MeetingScheduler;

import java.util.List;

public class Meeting {
    private String id;
    private Interval interval;
    private int capacity;
    private MeetingRoom room;
    private List<User> participants;

    public Meeting(String id, Interval interval, int capacity, MeetingRoom room, List<User> participants) {
        this.id = id;
        this.interval = interval;
        this.capacity = capacity;
        this.room = room;
        this.participants = participants;
    }

    public Interval getInterval() {
        return interval;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public String getId() {
        return id;
    }

    public MeetingRoom getRoom() {
        return room;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }
}

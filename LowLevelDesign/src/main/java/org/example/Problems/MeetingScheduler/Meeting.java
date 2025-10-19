package org.example.Problems.MeetingScheduler;


import java.util.List;

public class Meeting {
    private int id;
    private User host;
    private String name;
    private Interval interval;
    private int capacity;
    private MeetingRoom room;
    private List<User> participants;
    private Meeting meetingStatus;

    public Meeting(String name, Interval interval, int capacity, MeetingRoom room, List<User> participants, User host) {
        this.id = 1;
        this.interval = interval;
        this.capacity = capacity;
        this.room = room;
        this.participants = participants;
        this.host = host;
    }

    public int getId() {
        return id;
    }

    public Interval getInterval() {
        return interval;
    }

    public int getCapacity() {
        return capacity;
    }

    public MeetingRoom getRoom() {
        return room;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }
}

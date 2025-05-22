package org.example.Problems.MeetingScheduler;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoom {
    private String id;
    private String name;
    private String location;
    private int capacity;
    private List<Meeting> meetings = new ArrayList<>();

    public MeetingRoom(String id, String name, String location, int capacity) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
    }

    public boolean isAvailable(Interval interval)
    {
        for(Meeting meeting:meetings)
        {
            if(meeting.getInterval().overlaps(interval))
                return false;
        }
        return true;
    }

    public void addMeeting(Meeting meeting)
    {
        meetings.add(meeting);
    }

    public void removeMeeting(Meeting meeting)
    {
        meetings.remove(meeting);

    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getId() {
        return id;
    }
}

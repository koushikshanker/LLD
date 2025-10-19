package org.example.Problems.MeetingScheduler;


import java.util.List;

public class MeetingRoom {
    private int id;
    private String name;
    private int capacity;
    private String location;
    private List<Meeting> meetings;
    private MeetingRoomStatus meetingRoomStatus;

    public MeetingRoom(String name, int capacity, String location)
    {
        this.id = 1;
        this.capacity = capacity;
        this.location = location;
        this.meetingRoomStatus = MeetingRoomStatus.FREE;
    }

    public int getId() {
        return id;
    }

    public MeetingRoomStatus getMeetingRoomStatus() {
        return meetingRoomStatus;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getLocation() {
        return location;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

    public void removeMeeting(Meeting meeting) {
        meetings.remove(meeting);
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
}

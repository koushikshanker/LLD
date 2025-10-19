package org.example.Problems.MeetingScheduler;


import java.util.ArrayList;
import java.util.List;

public class MeetingRoomScheduler {
    BookingStrategy bookingStrategy;
    NotificationSubject notificationSubject;
    List<MeetingRoom> rooms;
    public MeetingRoomScheduler(List<MeetingRoom> rooms, BookingStrategy bookingStrategy)
    {
        this.bookingStrategy = bookingStrategy;
        this.notificationSubject = new NotificationSubject();
        this.rooms = rooms;
    }

    public Meeting bookMeeting(User host, Interval interval, int capacity, List<User> participants) {
        MeetingRoom room  = bookingStrategy.getMeetingRoom(interval,capacity);
        Meeting meeting = new Meeting("standup",interval,capacity,room, participants,host);
        room.addMeeting(meeting);
        nofityParticipants(participants);
        return meeting;
    }

    public void cancelMeeting(int meetingId)
    {
        Meeting meeting = getMeeting(meetingId);
        MeetingRoom room = meeting.getRoom();
        room.removeMeeting(meeting);
        nofityParticipants(meeting.getParticipants());
    }

    public void updateMeeting(int meetingId, Interval newInterval)
    {
        Meeting meeting = getMeeting(meetingId);
        MeetingRoom room = meeting.getRoom();
        if(room.isAvailable(newInterval))
        {
            meeting.setInterval(newInterval);
        }
        nofityParticipants(meeting.getParticipants());
    }

    public List<MeetingRoom> getAvailableMeetingRooms(int capacity, Interval interval)
    {
        List<MeetingRoom> available = new ArrayList<>();
        for(MeetingRoom room:rooms)
        {
            if(room.getCapacity()>=capacity && room.isAvailable(interval))
            {
                available.add(room);
            }
        }
        return available;
    }

    public Meeting getMeeting(int meetingId)
    {
        for(MeetingRoom room:rooms)
        {
            for(Meeting meeting: room.getMeetings())
            {
                if(meeting.getId()==meetingId)
                {
                    return meeting;
                }
            }
        }
        return null;
    }

    public void nofityParticipants(List<User> participants)
    {
        notificationSubject.notifyAll(participants,"notfity them");
    }
}

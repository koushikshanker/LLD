package org.example.Problems.MeetingScheduler;

import org.example.Problems.MeetingScheduler.BookingStrategy.BookingStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MeetingScheduler {
    private List<MeetingRoom> rooms;
    private BookingStrategy strategy;

    public MeetingScheduler(List<MeetingRoom> rooms, BookingStrategy strategy) {
        this.rooms = rooms;
        this.strategy = strategy;
    }

    public Meeting bookMeeting(Interval interval, int capacity, List<User> participants) {
        MeetingRoom room = strategy.findAvailableRoom(rooms, interval, capacity);
        if (room != null) {
            Meeting meeting = new Meeting(UUID.randomUUID().toString(), interval, capacity, room, participants);
            room.addMeeting(meeting);

            System.out.println("Booking Meetings");
            notifyParticipants(participants, "Meeting booked in Room " + room.getId() + " from " + interval.start + " to " + interval.end);

            return meeting;
        }

        return null;
    }

    public boolean cancelMeeting(String meetingId) {
        for (MeetingRoom room : rooms) {
            for (Meeting meeting : room.getMeetings()) {
                if (meeting.getId().equals(meetingId)) {
                    room.removeMeeting(meeting);

                    System.out.println("Cancelling Meetings");
                    notifyParticipants(meeting.getParticipants(), "Meeting " + meetingId + " cancelled.");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean updateMeeting(String meetingId, Interval newInterval) {
        for (MeetingRoom room : rooms) {
            for (Meeting meeting : room.getMeetings()) {
                if (meeting.getId().equals(meetingId)) {
                    if (room.isAvailable(newInterval)) {
                        meeting.setInterval(newInterval);

                        System.out.println("Rescheduling Meetings");
                        notifyParticipants(meeting.getParticipants(), "Rescheduled Meeting " + meetingId + " to " + newInterval.start + " - " + newInterval.end);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<MeetingRoom> getAvailableMeetingRooms(int capacity, Interval interval) {
        List<MeetingRoom> available = new ArrayList<>();
        for (MeetingRoom room : rooms) {
            if (room.getCapacity() >= capacity && room.isAvailable(interval)) {
                available.add(room);
            }
        }
        return available;
    }

    public void displayTodayMeetings() {
        LocalDateTime now = LocalDateTime.now();
        for (MeetingRoom room : rooms) {
            System.out.println("Room: " + room.getId());
            for (Meeting meeting : room.getMeetings()) {
                if (meeting.getInterval().start.toLocalDate().equals(now.toLocalDate())) {
                    System.out.println(" " + meeting.getInterval().start + " to " + meeting.getInterval().end);
                }
            }
        }
    }

    // ✅ Extracted helper method
    private void notifyParticipants(List<User> participants, String message) {
        NotificationSubject subject = new NotificationSubject();
        for (User user : participants) {
            subject.addObserver(new UserObserver(user));
        }
        subject.notifyAll(message);
    }
}

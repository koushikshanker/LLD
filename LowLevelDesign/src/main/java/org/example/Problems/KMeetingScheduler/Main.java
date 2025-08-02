package org.example.Problems.KMeetingScheduler;

import org.example.Problems.KMeetingScheduler.BookingStrategy.MinHeapBookingStrategy;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        //creating users
        User u1 = new User("1","Alice", "alice@gmail.com","1234");
        User u2 = new User("2","Bob", "bob@gmail.com","5678");
        List<User> participants = Arrays.asList(u1,u2);

        //create meeting rooms
        MeetingRoom r1 = new MeetingRoom("R1","Room1","1st Floor",4);
        MeetingRoom r2 = new MeetingRoom("R2","Room2","2nd floor",6);
        List<MeetingRoom> rooms = Arrays.asList(r1,r2);

        //create scheduler
        MeetingScheduler scheduler = new MeetingScheduler(rooms, new MinHeapBookingStrategy());

        //book a meeting
        LocalDateTime now = LocalDateTime.now();
        Interval interval = new Interval(now.plusHours(1), now.plusHours(2));
        Meeting meeting = scheduler.bookMeeting(interval,2,participants);

        //display meetings
        scheduler.displayTodayMeetings();

        //update meeting
        if(meeting!=null)
        {
            scheduler.updateMeeting(meeting.getId(), new Interval(now.plusHours(3), now.plusHours(4)));
        }

        //cancel meeting
        if(meeting!=null)
        {
            scheduler.cancelMeeting(meeting.getId());
        }
    }
}

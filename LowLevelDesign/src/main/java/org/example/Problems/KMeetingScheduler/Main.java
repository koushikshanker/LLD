package org.example.Problems.MeetingScheduler;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        //creating users
        User u1 = new User("Alice", "alice@gmail.com");
        User u2 = new User("Bob", "bob@gmail.com");
        List<User> participants = Arrays.asList(u1,u2);

        //create meeting rooms
        MeetingRoom r1 = new MeetingRoom("R1",4,"1st floor");
        MeetingRoom r2 = new MeetingRoom("R2",6,"2nd floor");
        List<MeetingRoom> rooms = Arrays.asList(r1,r2);

        //create scheduler
        MeetingRoomScheduler scheduler = new MeetingRoomScheduler(rooms,new MinHeapBookingStrategy(rooms));

        //book a meeting
        LocalDateTime now = LocalDateTime.now();
        Interval interval = new Interval(now.plusHours(1), now.plusHours(2));
        Meeting meeting = scheduler.bookMeeting(u1, interval,2,participants);

        //display meetings

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

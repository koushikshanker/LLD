package org.example.Problems.MeetingScheduler;

import com.sun.jdi.event.MethodEntryEvent;
import org.example.Problems.MeetingScheduler.BookingStrategy.MinHeapBookingStrategy;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MeetingSchedulerMain {
    public void MeetingMain()
    {
        User u1 = new User("1","Alice", "alice@gmail.com", "1234");
        User u2 = new User("2","Bob", "bob@gmail.com", "5678");
        List<User> participants = Arrays.asList(u1,u2);
        System.out.println("Added users");
        System.out.println("---------------------------");
        System.out.println();


        MeetingRoom r1 = new MeetingRoom("R1","Room 1","1st Floor",4);
        MeetingRoom r2 = new MeetingRoom("R2","Room 2","2nd Floor",6);
        List<MeetingRoom> rooms = Arrays.asList(r1,r2);
        System.out.println("Added rooms");
        System.out.println("---------------------------");
        System.out.println();

        MeetingScheduler scheduler = new MeetingScheduler(rooms, new MinHeapBookingStrategy());
        System.out.println("Built meeting scheduler with min heap booking strategy");
        System.out.println("---------------------------");
        System.out.println();

        LocalDateTime now = LocalDateTime.now();
        Interval interval = new Interval(now.plusHours(1),now.plusHours(2));
        Meeting meeting = scheduler.bookMeeting(interval,2,participants);

        System.out.println("Scheduled a meet with interval of 2hrs, 2 capacity and some users");
        System.out.println("---------------------------");
        System.out.println();

        System.out.println("Displaying Today's meetings");
        System.out.println("---------------------------");
        System.out.println();
        scheduler.displayTodayMeetings();
        System.out.println("---------------------------");
        System.out.println();

        if(meeting!=null)
        {
            System.out.println("Rescheduled the present meet");
            System.out.println("---------------------------");
            System.out.println();
            scheduler.updateMeeting(meeting.getId(), new Interval(now.plusHours(3),now.plusHours(4))   );
        }

        if(meeting!=null)
        {
            System.out.println("cancelled the meet");
            System.out.println("---------------------------");
            System.out.println();
            scheduler.cancelMeeting(meeting.getId());
        }
    }
}

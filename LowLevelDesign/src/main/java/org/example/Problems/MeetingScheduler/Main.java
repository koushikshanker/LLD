package org.example.Problems.MeetingScheduler;

import org.example.Problems.MeetingScheduler.BookingStrategy.MinHeapBookingStrategy;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public void MeetingMain()
    {
        User u1 = new User("1","Alice", "alice@gmail.com", "1234");
        User u2 = new User("2","Bob", "bob@gmail.com", "5678");
        List<User> participants = Arrays.asList(u1,u2);

        MeetingRoom r1 = new MeetingRoom("R1","Room 1","1st Floor",4);
        MeetingRoom r2 = new MeetingRoom("R2","Room 2","2nd Floor",6);
        List<MeetingRoom> rooms = Arrays.asList(r1,r2);

        MeetingScheduler scheduler = new MeetingScheduler(rooms, new MinHeapBookingStrategy());

        LocalDateTime now = LocalDateTime.now();
        Interval interval = new Interval(now.plusHours(1),now.plusHours(2));
        Optional<Meeting> meeting = scheduler.bookMeeting(interval,2,participants);

        scheduler.displayTodayMeetings();

        if(meeting.isPresent())
        {
            scheduler.updateMeeting(meeting.get().getId(), new Interval(now.plusHours(3),now.plusHours(4))   );
        }

        if(meeting.isPresent())
        {
            scheduler.cancelMeeting(meeting.get().getId());
        }
    }
}

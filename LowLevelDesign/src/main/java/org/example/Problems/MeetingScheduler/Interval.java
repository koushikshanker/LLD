package org.example.Problems.MeetingScheduler;

import java.time.LocalDateTime;

public class Interval {
    LocalDateTime start;
    LocalDateTime end;

    public Interval(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }
    public boolean overlaps(Interval other)
    {
        return !(this.end.isBefore(other.start) || this.start.isAfter(other.end));
    }
}

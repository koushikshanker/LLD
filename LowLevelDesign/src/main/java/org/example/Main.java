package org.example;

import org.example.Problems.AmazonLocker.AmazonLockerService;
import org.example.Problems.MeetingScheduler.MeetingScheduler;
import org.example.Problems.MeetingScheduler.MeetingSchedulerMain;
import org.example.Problems.MeetingScheduler.User;

public class Main {
    public static void main(String[] args) {
        AmazonLockerService ms = new AmazonLockerService();
        ms.run();
    }
}
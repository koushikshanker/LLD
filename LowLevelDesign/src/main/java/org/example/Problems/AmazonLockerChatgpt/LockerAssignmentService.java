package org.example.Problems.AmazonLockerChatgpt;

import java.util.List;

public class LockerAssignmentService {
    private List<Locker> lockers;
    public LockerAssignmentService(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Locker assignLocker(String location) {
        for (Locker l : lockers)
        {
            if (l.getLocation().equals(location))
            {
                System.out.println("Locker is assigned. Locker id: "+l.getId()+" with user's location: ");
                System.out.println("------------------------------");
                return l;
            }
        }
        return null;
    }
}

package org.example.Problems.AmazonLocker;

import java.util.ArrayList;
import java.util.List;

public class LockerStrategyService {
    private final List<Locker> lockers;
    public LockerStrategyService()
    {
        lockers = new ArrayList<>();
    }

    public void addLocker(Locker locker)
    {
        lockers.add(locker);
    }
    public Locker getLocker()
    {
        return lockers.getFirst();
    }



}

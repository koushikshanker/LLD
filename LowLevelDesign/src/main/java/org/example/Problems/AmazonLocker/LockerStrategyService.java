package org.example.Problems.AmazonLocker;

import java.util.ArrayList;
import java.util.List;

/**
 * Service to manage lockers and provide locker selection strategy.
 */
public class LockerStrategyService {
    private final List<Locker> lockers;

    public LockerStrategyService() {
        lockers = new ArrayList<>();
    }

    /**
     * Add a locker to the system.
     * @param locker Locker to add.
     */
    public void addLocker(Locker locker) {
        lockers.add(locker);
    }

    /**
     * Get a locker based on a strategy (e.g., location, availability).
     * Here, returns first available locker as a placeholder.
     *
     * @return Locker instance.
     * @throws IllegalStateException if no lockers are available.
     */
    public Locker getLocker() {
        if (lockers.isEmpty()) {
            throw new IllegalStateException("No lockers available");
        }
        // TODO: Implement more advanced selection strategy.
        return lockers.getFirst();
    }
}

package org.example.Problems.AmazonLocker;

public class SlotStrategyService {
    private final Locker locker;

    public SlotStrategyService(Locker locker) {
        this.locker = locker;
    }

    /**
     * Returns a slot based on the locker’s slot allocation strategy.
     * TODO: Implement a real strategy considering slot size, availability, etc.
     */
    public Slot getSlot() {
        return locker.getFreeSlot();
    }
}

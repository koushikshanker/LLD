package org.example.Problems.AmazonLocker;

public class SlotStrategyService
{
    Locker locker;
    public SlotStrategyService(Locker locker)
    {
        this.locker = locker;
    }

    public Slot getSlot()
    {
        return locker.getSlot();
    }
}

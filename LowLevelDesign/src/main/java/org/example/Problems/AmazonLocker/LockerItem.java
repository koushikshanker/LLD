package org.example.Problems.AmazonLocker;

public class LockerItem {
    private int id;
    private String name;
    private LockerItemStatus status;
    private Locker locker;
    private Slot slot;

    public LockerItem(int id, String name) {
        this.id = id;
        this.name = name;
        this.status= LockerItemStatus.IDLE;
        this.locker = null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LockerItemStatus getStatus() {
        return status;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}

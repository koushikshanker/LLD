package org.example.Problems.AmazonLocker;

/**
 * Represents an item stored in a locker.
 */
public class LockerItem {
    private final int id;
    private final String name;
    private LockerItemStatus status;
    private Locker locker;
    private Slot slot;

    public LockerItem(int id, String name) {
        this.id = id;
        this.name = name;
        this.status = LockerItemStatus.IDLE;
        this.locker = null;
        this.slot = null;
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

    public void setStatus(LockerItemStatus status) {
        this.status = status;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "LockerItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", locker=" + (locker != null ? locker.getName() : "null") +
                ", slot=" + (slot != null ? slot.getName() : "null") +
                '}';
    }
}

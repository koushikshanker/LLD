package org.example.Problems.AmazonLocker;

import java.util.Objects;

/**
 * Represents a single locker slot where items can be stored.
 */
public class Slot {
    private final int id;
    private String name;
    private String size;
    private SlotStatus status;
    private LockerItem lockerItem;
    private String otp;

    public Slot(int id, String name, String size) {
        this.id = id;
        this.name = Objects.requireNonNull(name, "name cannot be null");
        this.size = Objects.requireNonNull(size, "size cannot be null");
        this.status = SlotStatus.FREE;
        this.lockerItem = null;
        this.otp = null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "name cannot be null");
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = Objects.requireNonNull(size, "size cannot be null");
    }

    public SlotStatus getStatus() {
        return status;
    }

    public void setStatus(SlotStatus status) {
        this.status = Objects.requireNonNull(status, "status cannot be null");
    }

    public LockerItem getLockerItem() {
        return lockerItem;
    }

    public void setLockerItem(LockerItem lockerItem) {
        this.lockerItem = lockerItem;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", status=" + status +
                ", lockerItem=" + (lockerItem != null ? lockerItem.getName() : "null") +
                ", otp='" + otp + '\'' +
                '}';
    }
}

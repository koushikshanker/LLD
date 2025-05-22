package org.example.Problems.AmazonLocker;

public class Slot {
    int id;
    String name;
    String size;
    SlotStatus status;
    LockerItem lockerItem;
    String otp;

    public Slot(int id, String name, String size) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.status = SlotStatus.FREE;
        this.lockerItem = null;
        this.otp=null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public SlotStatus getStatus() {
        return status;
    }

    public void setStatus(SlotStatus status) {
        this.status = status;
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
}

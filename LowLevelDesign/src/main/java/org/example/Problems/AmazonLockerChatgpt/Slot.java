package org.example.Problems.AmazonLockerChatgpt;

public class Slot {
    private String id;
    private SlotStatus status;
    private String otp;
    private Item item;
    private SlotSize size;

    public Slot(String id, SlotSize size) {
        this.id = id;
        this.size = size;
        this.status = SlotStatus.FREE;
    }

    public boolean validateOtp(String otp) {
        System.out.println("validating otp");
        System.out.println("------------------------------");
        return this.otp != null && this.otp.equals(otp);
    }

    public void reserve(String otp) {
        System.out.println("Slot is marked as reserved");
        System.out.println("------------------------------");
        this.status = SlotStatus.RESERVED;
        this.otp = otp;
    }

    public void occupy(Item item) {
        System.out.println("Slot is marked as occupied");
        System.out.println("------------------------------");
        this.status = SlotStatus.OCCUPIED;
        this.item = item;
    }

    public void free() {
        System.out.println("Slot is marked as free");
        System.out.println("------------------------------");
        this.status = SlotStatus.FREE;
        this.otp = null;
        this.item = null;
    }

    public String getId() { return id; }
    public SlotStatus getStatus() { return status; }
    public String getOtp() { return otp; }
    public Item getItem() { return item; }
    public SlotSize getSize() { return size; }
}

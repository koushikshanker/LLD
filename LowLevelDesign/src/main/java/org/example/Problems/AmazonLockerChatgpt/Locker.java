package org.example.Problems.AmazonLockerChatgpt;

import java.util.List;

public class Locker {
    private String id;
    private String location;
    private List<Slot> slots;

    public Locker(String id, String location, List<Slot> slots) {
        this.id = id;
        this.location = location;
        this.slots = slots;
    }

    public Slot getFreeSlot(SlotSize size) {
        for (Slot s : slots) {
            if (s.getStatus() == SlotStatus.FREE && s.getSize() == size) return s;
        }
        return null;
    }

    public String getId() { return id; }
    public String getLocation() { return location; }
    public List<Slot> getSlots() { return slots; }
}

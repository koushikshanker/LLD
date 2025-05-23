package org.example.Problems.AmazonLockerChatgpt;

public class SlotAssignmentService {
    public Slot assignSlot(Locker locker, SlotSize size) {
        Slot slot = locker.getFreeSlot(size);
        System.out.println("Slot is assigned. slot id: "+slot.getId()+" with item's size: "+size);
        System.out.println("------------------------------");
        return slot;
    }
}

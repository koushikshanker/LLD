package org.example.Problems.AmazonLocker;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Represents a physical locker containing multiple slots.
 */
public class Locker {
    private final int id;
    private String name;
    private String location;
    private final List<Slot> slots;

    public Locker(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.slots = new ArrayList<>();
    }

    /**
     * Add a slot to this locker.
     */
    public void addSlot(Slot slot) {
        slots.add(slot);
    }

    /**
     * Remove a slot from this locker.
     */
    public void removeSlot(Slot slot) {
        slots.remove(slot);
    }

    /**
     * Get a free slot for allocation.
     * TODO: Extend strategy to support size or other criteria.
     *
     * @return a free Slot
     * @throws NoSuchElementException if no free slot available
     */
    public Slot getFreeSlot() {
        return slots.stream()
                .filter(slot -> slot.getStatus() == SlotStatus.FREE)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No free slots available"));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Return a copy of slots to avoid external modification.
     */
    public List<Slot> getSlots() {
        return new ArrayList<>(slots);
    }
}

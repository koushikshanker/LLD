package org.example.Problems.AmazonLocker;

import java.util.ArrayList;
import java.util.List;

public class Locker {
    private int id;
    private String name;
    private String location;
    private List<Slot> slots;

    public Locker(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.slots = new ArrayList<>();
    }

    public void addSlot(Slot slot)
    {
        slots.add(slot);
    }
    public void removeSlot(Slot slot)
    {
        slots.remove(slot);
    }

    public Slot getSlot()
    {
        //Todo, get slot based on size or any other strategy
        return slots.getFirst();
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }
}

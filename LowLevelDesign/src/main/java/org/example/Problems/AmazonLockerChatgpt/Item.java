package org.example.Problems.AmazonLockerChatgpt;

public class Item {
    private String id;
    private String description;
    private SlotSize size;

    public Item(String id, String description, SlotSize size) {
        this.id = id;
        this.description = description;
        this.size = size;
    }
    public String getId() { return id; }
    public String getDescription() { return description; }
    public SlotSize getSize() { return size; }
}

package org.example.Problems.AmazonLockerChatgpt;

public class DeliveryPerson {
    private String id;
    private String name;
    private String email;
    private String location;
    private boolean available = true;

    public DeliveryPerson(String id, String name, String email, String location) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.location = location;
    }
    public String getEmail() { return email; }
    public String getId() { return id; }
    public String getLocation() { return location; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) {
        System.out.println("Marking deliverperson as not available");
        System.out.println("------------------------------");
        this.available = available; }
}

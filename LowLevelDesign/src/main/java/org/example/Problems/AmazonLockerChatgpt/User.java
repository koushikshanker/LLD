package org.example.Problems.AmazonLockerChatgpt;

public class User {
    private String id;
    private String name;
    private String email;
    private String location;

    public User(String id, String name, String email, String location) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.location = location;
    }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getId() { return id; }
    public String getLocation() { return location; }
}

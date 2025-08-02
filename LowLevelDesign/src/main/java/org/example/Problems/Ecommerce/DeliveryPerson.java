package org.example.Problems.Ecommerce;

import java.util.UUID;

public class DeliveryPerson {
    private final String id;
    private String name;
    private String phoneNumber;
    private String email;
    private DeliveryPersonStatus status;

    public DeliveryPerson(String name, String phoneNumber, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = DeliveryPersonStatus.AVAILABLE;
    }

    // Getters and setters
    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public DeliveryPersonStatus getStatus() { return status; }
    public void setStatus(DeliveryPersonStatus status) { this.status = status; }
}

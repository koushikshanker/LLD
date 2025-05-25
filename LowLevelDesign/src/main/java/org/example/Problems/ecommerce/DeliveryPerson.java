package org.example.Problems.ecommerce;

public class DeliveryPerson {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private DeliveryPersonStatus deliveryPersonStatus;

    public DeliveryPerson(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.deliveryPersonStatus = DeliveryPersonStatus.AVAILABLE;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DeliveryPersonStatus getDeliveryPersonStatus() {
        return deliveryPersonStatus;
    }

    public void setDeliveryPersonStatus(DeliveryPersonStatus deliveryPersonStatus) {
        this.deliveryPersonStatus = deliveryPersonStatus;
    }
}

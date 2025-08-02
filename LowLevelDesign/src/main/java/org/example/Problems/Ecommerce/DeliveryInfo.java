package org.example.Problems.Ecommerce;

public class DeliveryInfo {
    private Address deliveryAddress;
    private String trackingNumber;

    public DeliveryInfo(Address deliveryAddress, String trackingNumber) {
        this.deliveryAddress = deliveryAddress;
        this.trackingNumber = trackingNumber;
    }

    // getters and setters
    public Address getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(Address deliveryAddress) { this.deliveryAddress = deliveryAddress; }

    public String getTrackingNumber() { return trackingNumber; }
    public void setTrackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; }
}

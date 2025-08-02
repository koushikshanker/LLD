package org.example.Problems.Ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final String id;
    private String name;
    private String phoneNumber;
    private String email;
    private List<Address> addresses;
    private List<Order> orders;

    public User(String name, String phoneNumber, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.addresses = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    // Other getters/setters omitted for brevity

    public List<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

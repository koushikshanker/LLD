package org.example.Problems.KAtmDesign;

import java.util.UUID;

public class ATM {
    private String id;
    private String location;
    private Double balance;

    public ATM(String location, Double balance) {
        this.id = UUID.randomUUID().toString();
        this.location = location;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}

package org.example.Problems.KAtmDesign;

import java.util.UUID;

public class Card {
    private String id;
    private Integer cardNumber;
    private String expiry;
    private Integer CVV;
    private Integer pin;
    private Account account;

    public Card(Integer cardNumber, String expiry, Integer CVV, Integer pin, Account account) {
        this.id = UUID.randomUUID().toString();
        this.cardNumber = cardNumber;
        this.expiry = expiry;
        this.CVV = CVV;
        this.pin = pin;
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public String getExpiry() {
        return expiry;
    }

    public Integer getCVV() {
        return CVV;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public Account getAccount() {
        return account;
    }
}

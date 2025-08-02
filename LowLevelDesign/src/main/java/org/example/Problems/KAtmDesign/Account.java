package org.example.Problems.KAtmDesign;

import java.util.UUID;

public class Account {
    private String id;
    private String branch;
    private User user;
    private Double balance;
    private AccountType accountType;

    public Account(String branch, User user, Double balance, AccountType accountType) {
        this.id = UUID.randomUUID().toString();
        this.branch = branch;
        this.user = user;
        this.balance = balance;
        this.accountType = accountType;
    }

    public String getId() {
        return id;
    }

    public String getBranch() {
        return branch;
    }

    public User getUser() {
        return user;
    }

    public Double getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}

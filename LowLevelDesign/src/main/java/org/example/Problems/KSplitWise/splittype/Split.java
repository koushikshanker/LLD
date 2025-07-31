package org.example.Problems.KSplitWise.splittype;

import org.example.Problems.KSplitWise.User;

public abstract class Split {
    protected User user;
    protected double amount;

    public Split(User user) {
        this.user = user;
    }

    public abstract double getAmount();

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }
}


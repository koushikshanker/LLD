package org.example.Problems.KSplitWise.splittype;

import org.example.Problems.KSplitWise.User;

public class EqualSplit extends Split {
    public EqualSplit(User user) {
        super(user);
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

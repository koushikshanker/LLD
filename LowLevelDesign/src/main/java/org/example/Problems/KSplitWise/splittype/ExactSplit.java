package org.example.Problems.KSplitWise.splittype;

import org.example.Problems.KSplitWise.User;

public class ExactSplit extends Split{
    public ExactSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }

    @Override
    public double getAmount() {
        return amount;
    }
}

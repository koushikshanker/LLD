package org.example.Problems.KSplitWise.splittype;

import org.example.Problems.KSplitWise.User;

public class PercentSplit extends Split{
    private final double percent;

    public PercentSplit(User user, double percent) {
        super(user);
        this.percent = percent;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public double getPercent() {
        return percent;
    }
}

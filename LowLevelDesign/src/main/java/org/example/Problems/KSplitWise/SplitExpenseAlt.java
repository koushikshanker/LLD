package org.example.Problems.KSplitWise;

import org.example.Problems.KSplitWise.splittype.EqualSplit;
import org.example.Problems.KSplitWise.splittype.ExactSplit;
import org.example.Problems.KSplitWise.splittype.PercentSplit;
import org.example.Problems.KSplitWise.splittype.Split;

import java.util.List;

public class SplitExpenseAlt
{
    public void processSplits(Expense expense)
    {
        double totalAmount = expense.getAmount();
        List<Split> splits = expense.getSplits();

        double exactTotal = 0;
        double percentTotal = 0;
        int equalSplitCount = 0;

        // First pass: validation and prep
        for (Split split : splits)
        {
            if (split instanceof ExactSplit)
            {
                exactTotal += split.getAmount(); // Already set by caller
            }
            else if (split instanceof PercentSplit)
            {
                percentTotal += ((PercentSplit) split).getPercent();
            }
            else if (split instanceof EqualSplit)
            {
                equalSplitCount++;
            }
            else
            {
                throw new IllegalArgumentException("Unsupported split type: " + split.getClass().getSimpleName());
            }
        }

        // Validate percent total
        if (percentTotal > 100.0)
        {
            throw new IllegalArgumentException("Total percentage of PercentSplits exceeds 100%");
        }

        double percentAmount = totalAmount * percentTotal / 100.0;
        double remainingAmount = totalAmount - exactTotal - percentAmount;

        if (remainingAmount < 0)
        {
            throw new IllegalArgumentException(
                    "Total of ExactSplits and PercentSplits exceeds expense amount. " +
                            "Exact: $" + exactTotal + ", Percent: $" + percentAmount + ", Total: $" + totalAmount
            );
        }

        if (equalSplitCount > 0 && remainingAmount == 0)
        {
            throw new IllegalArgumentException("No amount left to distribute among EqualSplits");
        }

        double equalShare = equalSplitCount > 0 ? remainingAmount / equalSplitCount : 0;

        // Second pass: assign amounts
        for (Split split : splits)
        {
            if (split instanceof PercentSplit percentSplit)
            {
                double amount = totalAmount * percentSplit.getPercent() / 100.0;
                split.setAmount(amount);
            }
            else if (split instanceof EqualSplit)
            {
                split.setAmount(equalShare);
            }
            // ExactSplit already has amount assigned, do nothing
        }

        // Optional: verify final total sums to totalAmount (for debug/safety)
        double sum = splits.stream().mapToDouble(Split::getAmount).sum();
        if (Math.abs(sum - totalAmount) > 0.01)
        {
            throw new IllegalStateException("Split amounts do not sum to total. Total: $" + totalAmount + ", Sum of Splits: $" + sum);
        }
    }

}

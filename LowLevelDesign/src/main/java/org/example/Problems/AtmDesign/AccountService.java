package org.example.Problems.AtmDesign;

public class AccountService {
    private Account account;
    public AccountService(Account account)
    {
        this.account =account;
    }
    public Double getBalance()
    {
        return account.getBalance();
    }

    //int Integer
    public boolean validateBalanceAgainstWithDrawalAmount(Double withDrawalAmount)
    {
        System.out.println("Validating balance against with drawal amount");
        System.out.println("------------------------");
        return account.getBalance()>withDrawalAmount;
    }

    public Double withDrawAmount(Double withDrawalAmount)
    {
        System.out.println("with drawing amount");
        System.out.println("------------------------");
        return updatesBalanceInAccount(withDrawalAmount);
    }
    public Double updatesBalanceInAccount(Double withDrawalAmount)
    {
        System.out.println("Updating balance in account");
        System.out.println("------------------------");
        double balanceAmountAfterDeduction = account.getBalance()-withDrawalAmount;
        account.setBalance(balanceAmountAfterDeduction);
        return withDrawalAmount;
    }

    public Account getAccount() {
        return account;
    }
}

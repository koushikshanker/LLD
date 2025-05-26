package org.example.Problems.AtmDesign;

public class Main {
    public static void main(String[] args) {
            User user = new User("ramesh","9908");
            Account account = new Account("kkkp",user,100000.0,AccountType.SAVINGS);
            Card card = new Card(42424,"03/30",100,777,account);
            ATM atm = new ATM("kkp", 900000.0);

            ATMService atmService = new ATMService(card,user,atm);

            Integer UserEnteredPin = 777;
            Double UserEnteredAmount = 10000.0;

            atmService.validateCardChip(card);

            atmService.validateCard(card);

            Boolean isPinValid = atmService.validateCardPin(UserEnteredPin);
            if(isPinValid)
            {

                if(atmService.getAccountService().validateBalanceAgainstWithDrawalAmount(UserEnteredAmount))
                {
                    Double withDrawalMoney = atmService.withDrawMoney(UserEnteredAmount);
                    if(withDrawalMoney!=null)
                    {
                        Double ejectedCash = atmService.ejectCash(isPinValid,withDrawalMoney);
                        if(ejectedCash!=null)
                        {
                            atmService.ejectCard(true, card);
                            System.out.println("User account balance "+account.getBalance());
                        }
                        else
                        {
                            System.out.println("Unable to eject cash");
                        }
                    }
                    else
                    {
                        System.out.println("Atm doesnt have money");
                    }
                }
                else
                {
                    System.out.println("Withdrawal amount is greater than account balance");
                }
            }
            else
            {
                System.out.println("Invalid ping");
            }
    }
}

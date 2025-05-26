package org.example.Problems.AtmDesign;


import java.util.Objects;

public class ATMService {
    private NotificationService notificationService;
    private CardService cardService;
    private AccountService accountService;
    private ATM atm;
    private Transaction transaction;
    private static ATMService instance = null;
    private User user;

    ATMService(Card card, User user, ATM atm)
    {
        this.notificationService = new NotificationService(user);
        this.cardService = new CardService(card);
        this.accountService = new AccountService(card.getAccount());
        this.atm = atm;
        this.user = user;
    }
    public boolean validateCardChip(Card card)
    {
        System.out.println("Validating card chip");
        System.out.println("------------------------");
        //can add some card logic to validate card chip
        return card!=null;
    }

    public boolean validateCard(Card card)
    {
        return cardService.validateCard();
    }


    public boolean validateCardPin(Integer userEnteredPin)
    {
        return cardService.validatePin(userEnteredPin);

    }

    public Double withDrawMoney(Double userEnteredAmount)
    {
        transaction = new Transaction(userEnteredAmount,user, cardService.getCard(),accountService.getAccount());
        if(validateBalanceInATM(userEnteredAmount))
        {
            return accountService.withDrawAmount(userEnteredAmount) ;
        }

        return null;
    }

    private boolean validateBalanceInATM(Double userEnteredAmount) {
        System.out.println("Check whether atm has enough amount");
        return atm.getBalance()>userEnteredAmount;
    }

    public Double ejectCash(Boolean isPinValidated, Double withDrawalAmount)
    {
        if(isPinValidated)
        {
            Double atmBalanceAfterWithDrawal = atm.getBalance()-withDrawalAmount;
            atm.setBalance(atmBalanceAfterWithDrawal);
            transaction.setTransactionStatus(TransactionStatus.AUTHORIZED);
            System.out.println("updating atm balance: "+atmBalanceAfterWithDrawal);
            System.out.println("Take cash amount: "+withDrawalAmount);

            return atmBalanceAfterWithDrawal;
        }
        return null;
    }

    public Card ejectCard(boolean isCashWithDrawn, Card card)
    {
        if(isCashWithDrawn)
        {
            System.out.println("Ejecting card");
            return card;
        }
        return null;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public CardService getCardService() {
        return cardService;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public ATM getAtm() {
        return atm;
    }
}

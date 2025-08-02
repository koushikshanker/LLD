package org.example.Problems.KAtmDesign;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class CardService {
    private Card card;
    public CardService(Card card)
    {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }
    public boolean validateCard()
    {
        System.out.println("Validating card");
        System.out.println("------------------------");
        return validateCardNumber() && validateExpiry();
    }

    boolean validatePin(Integer userEnteredPin) {
        System.out.println("Validating pin");
        System.out.println("------------------------");
        return Objects.equals(userEnteredPin, card.getPin());
    }

    private boolean validateExpiry() {
        System.out.println("Validating expiry");
        System.out.println("------------------------");
        String expiry = card.getExpiry();
        if (expiry == null || !expiry.matches("^\\d{2}/\\d{2}$")) {
            return false;
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
            YearMonth expiryDate = YearMonth.parse(expiry, formatter);

            // Get current YearMonth
            YearMonth currentMonth = YearMonth.now();

            // Expiry must be this month or later
            return !expiryDate.isBefore(currentMonth);
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public boolean validateCardNumber()
    {
        System.out.println("Validating card number");
        System.out.println("------------------------");
        //can add some card logic to validate card chip
        Integer cardNumber = card.getCardNumber();
        String cardNumberInString = cardNumber.toString();
        String first4digits = cardNumberInString.substring(0,4);
        return first4digits.equals("4242");
    }

    public boolean validateCardCVV(Card card, Integer userEnteredCVV)
    {
        System.out.println("Validating card cvv");
        System.out.println("------------------------");
        return Objects.equals(card.getCVV(), userEnteredCVV);
    }
}

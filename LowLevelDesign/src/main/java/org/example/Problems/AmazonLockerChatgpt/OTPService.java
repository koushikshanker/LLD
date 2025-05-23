package org.example.Problems.AmazonLockerChatgpt;

import java.util.Random;

public class OTPService {
    public String generateOtp() {
        System.out.println("Generating otp ");
        System.out.println("------------------------------");
        return String.valueOf(new Random().nextInt(899999) + 100000);
    }
}

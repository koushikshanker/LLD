package org.example.Problems.AmazonLocker;

import java.security.SecureRandom;

/**
 * Service responsible for generating secure OTPs for locker access.
 */
public class OtpGenerationService {

    private static final int OTP_LENGTH = 6;
    private static final String DIGITS = "0123456789";
    private final SecureRandom random = new SecureRandom();

    /**
     * Generates a random numeric OTP of fixed length.
     *
     * @return A securely generated OTP string.
     */
    public String generateOtp() {
        StringBuilder otpBuilder = new StringBuilder(OTP_LENGTH);
        for (int i = 0; i < OTP_LENGTH; i++) {
            int index = random.nextInt(DIGITS.length());
            otpBuilder.append(DIGITS.charAt(index));
        }
        return otpBuilder.toString();
    }
}

package org.example.Problems.Ecommerce;

public class PaymentService {

    public boolean processPayment(Order order) {
        // Simplified payment processing simulation
        order.setPaymentStatus(PaymentStatus.PAID);
        return true; // return false if payment fails
    }

    public void refund(Order order) {
        order.setPaymentStatus(PaymentStatus.REFUNDED);
        // Implement refund logic here
    }
}

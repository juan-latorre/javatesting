package com.javatestprj.javatesting.payments;

public interface PaymentGateway {
    PaymentResponse requestPayment(PaymentRequest request);
}

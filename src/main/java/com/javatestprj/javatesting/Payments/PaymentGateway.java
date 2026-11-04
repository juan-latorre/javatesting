package com.javatestprj.javatesting.Payments;

public interface PaymentGateway {
    PaymentResponse requestPayment(PaymentRequest request);
}

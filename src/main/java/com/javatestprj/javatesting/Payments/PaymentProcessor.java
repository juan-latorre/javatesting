package com.javatestprj.javatesting.Payments;

public class PaymentProcessor {

    private PaymentGateway gateway;

    public PaymentProcessor(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public boolean makePayment(double amount) {
        PaymentRequest request = new PaymentRequest(amount);
        PaymentResponse response = gateway.requestPayment(request);
        return response.getStatus() == PaymentResponse.PaymentStatus.OK;
    }
}

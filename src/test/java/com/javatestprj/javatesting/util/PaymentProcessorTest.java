package com.javatestprj.javatesting.util;

import com.javatestprj.javatesting.Payments.PaymentGateway;
import com.javatestprj.javatesting.Payments.PaymentProcessor;
import com.javatestprj.javatesting.Payments.PaymentRequest;
import com.javatestprj.javatesting.Payments.PaymentResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PaymentProcessorTest {

    @Test
    public void testPaymentProcessor() {
        PaymentGateway mockGateway = mock(PaymentGateway.class);

        when(mockGateway.requestPayment(any(PaymentRequest.class)))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        PaymentProcessor processor = new PaymentProcessor(mockGateway);
        assertTrue(processor.makePayment(1000.0));
    }

    @Test
    public void testPaymentProcessorWithError() {
        PaymentGateway mockGateway = mock(PaymentGateway.class);

        when(mockGateway.requestPayment(any(PaymentRequest.class)))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        PaymentProcessor processor = new PaymentProcessor(mockGateway);
        assertFalse(processor.makePayment(100.0));
    }
}
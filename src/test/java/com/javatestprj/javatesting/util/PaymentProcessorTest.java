package com.javatestprj.javatesting.util;

import com.javatestprj.javatesting.Payments.PaymentGateway;
import com.javatestprj.javatesting.Payments.PaymentProcessor;
import com.javatestprj.javatesting.Payments.PaymentRequest;
import com.javatestprj.javatesting.Payments.PaymentResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PaymentProcessorTest {

    private PaymentGateway mockGateway;
    private PaymentProcessor processor;

    @BeforeEach
    void setUp() {
        // Se ejecuta automáticamente antes de cada @Test
        mockGateway = mock(PaymentGateway.class);
        processor = new PaymentProcessor(mockGateway);
    }

    @Test
    void testMakePayment_whenGatewayReturnsOk_returnsTrue() {
        when(mockGateway.requestPayment(any(PaymentRequest.class)))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        boolean result = processor.makePayment(100.0);

        assertTrue(result, "Debe ser true si la pasarela responde OK.");
    }

    @Test
    void testMakePayment_whenGatewayReturnsError_returnsFalse() {
        when(mockGateway.requestPayment(any(PaymentRequest.class)))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        boolean result = processor.makePayment(100.0);

        assertFalse(result, "Debe ser false si la pasarela responde ERROR.");
    }
}
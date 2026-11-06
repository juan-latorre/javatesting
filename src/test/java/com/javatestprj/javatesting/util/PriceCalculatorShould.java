package com.javatestprj.javatesting.util;

import com.javatestprj.javatesting.discounts.PriceCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceCalculatorShould {

    private PriceCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new PriceCalculator();
    }

    @Test
    void return_zero_when_there_are_no_prices() {
        assertEquals(0.0, calculator.getTotal(), 0.001,
                "El total inicial sin precios debe ser 0.0");
    }

    @Test
    void return_sum_of_all_added_prices() {
        calculator.addPrice(10.2);
        calculator.addPrice(15.5);

        assertEquals(25.7, calculator.getTotal(), 0.001,
                "El total debe ser la suma exacta de los precios introducidos");
    }

    @Test
    void apply_discount_to_total() {
        calculator.addPrice(100.0);
        calculator.addPrice(50.0);
        calculator.setDiscount(25.0);

        assertEquals(112.5, calculator.getTotal(), 0.001,
                "Un descuento del 25% sobre 150 debe dar 112.5");
    }
}
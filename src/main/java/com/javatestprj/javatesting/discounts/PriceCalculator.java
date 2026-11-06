package com.javatestprj.javatesting.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {
    private final List<Double> prices = new ArrayList<>();
    private double discount = 0.0;

    public void addPrice(double price) {
        prices.add(price);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotal() {
        double subtotal = 0.0;
        for (double price : prices) {
            subtotal += price;
        }

        return subtotal - (subtotal * discount / 100.0);
    }
}

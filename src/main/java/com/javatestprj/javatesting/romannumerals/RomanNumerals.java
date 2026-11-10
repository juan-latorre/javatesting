package com.javatestprj.javatesting.romannumerals;

public class RomanNumerals {
    private static final int[] ARABIC_VALUES = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4,
            1
    };

    private static final String[] ROMAN_SYMBOLS = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV",
            "I"
    };

    public static String arabicToRoman(int n) {
        StringBuilder result = new StringBuilder();
        int remaining = n;

        for (int i = 0; i < ARABIC_VALUES.length; i++) {
            while (remaining >= ARABIC_VALUES[i]) {
                result.append(ROMAN_SYMBOLS[i]);
                remaining -= ARABIC_VALUES[i];
            }
        }

        return result.toString();
    }
}

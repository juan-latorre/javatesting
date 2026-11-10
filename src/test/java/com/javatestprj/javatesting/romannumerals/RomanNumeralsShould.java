package com.javatestprj.javatesting.romannumerals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsShould {

    @Test
    void convert_single_and_repeated_units() {
        assertEquals("I", RomanNumerals.arabicToRoman(1));
        assertEquals("II", RomanNumerals.arabicToRoman(2));
        assertEquals("III", RomanNumerals.arabicToRoman(3));
    }

    @Test
    void convert_base_symbols_and_simple_additions() {
        assertEquals("V", RomanNumerals.arabicToRoman(5));
        assertEquals("VI", RomanNumerals.arabicToRoman(6));
        assertEquals("VII", RomanNumerals.arabicToRoman(7));
        assertEquals("X", RomanNumerals.arabicToRoman(10));
        assertEquals("XI", RomanNumerals.arabicToRoman(11));
        assertEquals("XV", RomanNumerals.arabicToRoman(15));
        assertEquals("XVI", RomanNumerals.arabicToRoman(16));
        assertEquals("L", RomanNumerals.arabicToRoman(50));
        assertEquals("LI", RomanNumerals.arabicToRoman(51));
        assertEquals("LV", RomanNumerals.arabicToRoman(55));
        assertEquals("LVI", RomanNumerals.arabicToRoman(56));
        assertEquals("LX", RomanNumerals.arabicToRoman(60));
        assertEquals("LXX", RomanNumerals.arabicToRoman(70));
        assertEquals("LXXX", RomanNumerals.arabicToRoman(80));
        assertEquals("LXXXI", RomanNumerals.arabicToRoman(81));
        assertEquals("LXXXV", RomanNumerals.arabicToRoman(85));
        assertEquals("LXXXVI", RomanNumerals.arabicToRoman(86));
    }

    @Test
    void convert_subtractive_combinations() {
        assertEquals("IV", RomanNumerals.arabicToRoman(4));
        assertEquals("IX", RomanNumerals.arabicToRoman(9));
        assertEquals("XIV", RomanNumerals.arabicToRoman(14));
        assertEquals("XIX", RomanNumerals.arabicToRoman(19));
        assertEquals("XXIV", RomanNumerals.arabicToRoman(24));
        assertEquals("XL", RomanNumerals.arabicToRoman(40));
        assertEquals("XLIX", RomanNumerals.arabicToRoman(49));
        assertEquals("XC", RomanNumerals.arabicToRoman(90));
        assertEquals("XCIX", RomanNumerals.arabicToRoman(99));
        assertEquals("CD", RomanNumerals.arabicToRoman(400));
        assertEquals("CM", RomanNumerals.arabicToRoman(900));
    }

    @Test
    void convert_complex_composite_numbers() {
        assertEquals("CXXVI", RomanNumerals.arabicToRoman(126));
        assertEquals("MMDVII", RomanNumerals.arabicToRoman(2507));
    }

}
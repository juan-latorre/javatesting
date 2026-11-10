package com.javatestprj.javatesting.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzShould {
    @Test
    void return_fizz_when_number_is_divisible_by_3() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
        assertEquals("Fizz", FizzBuzz.fizzBuzz(6));
    }

    @Test
    void return_buzz_when_number_is_divisible_by_5() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
    }

    @Test
    void return_fizzbuzz_when_number_is_divisible_by_both_3_and_5() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(30));
    }

    @Test
    void return_number_as_string_when_not_divisible_by_3_or_5() {
        assertEquals("2", FizzBuzz.fizzBuzz(2));
        assertEquals("16", FizzBuzz.fizzBuzz(16));
    }
}
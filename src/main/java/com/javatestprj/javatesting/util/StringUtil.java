package com.javatestprj.javatesting.util;

public class StringUtil {
    public static String repeat(String str, int times) {

        if (times < 0) {
            throw new IllegalArgumentException("Times must be non-negative");
        }

        //return String.valueOf(String.valueOf(str)).repeat(Math.max(0, times));
        if (str == null) {
            return null; // o lanza IllegalArgumentException si no permites nulos
        }

        return str.repeat(times);
    }
}

package com.javatestprj.javatesting.util;

public class StringUtil {
    public static String repeat(String str, int times) {

        return String.valueOf(String.valueOf(str)).repeat(Math.max(0, times));
    }
}

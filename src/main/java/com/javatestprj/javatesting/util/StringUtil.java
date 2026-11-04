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

    /**
     * Evalúa si un string está vacío, es nulo o contiene solo espacios en blanco.
     *
     * @param str la cadena a evaluar
     * @return true si es null, si tiene longitud 0 o si tras aplicar trim() queda vacía; false en caso contrario.
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}

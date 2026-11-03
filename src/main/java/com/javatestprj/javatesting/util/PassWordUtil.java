package com.javatestprj.javatesting.util;

public class PassWordUtil {

    public static SecurityLevel assessPassword(String password) {
        if (password == null || password.length() < 8) {
            return SecurityLevel.WEAK;
        }

        // Si solo contiene letras (sin importar mayúsculas/minúsculas)
        if (password.matches("[a-zA-Z]+")) {
            return SecurityLevel.WEAK;
        }

        // Si contiene letras y números, pero ningún símbolo especial
        if (password.matches("[a-zA-Z0-9]+")) {
            return SecurityLevel.MEDIUM;
        }

        // Si tiene al menos 8 caracteres e incluye símbolos especiales
        return SecurityLevel.STRONG;
    }
}

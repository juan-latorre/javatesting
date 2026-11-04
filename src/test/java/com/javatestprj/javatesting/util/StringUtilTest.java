package com.javatestprj.javatesting.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilTest {

  @Test
  void testRepeat_string_once_times() {
    // Arrange & Act
    String result = StringUtil.repeat("abc", 1);

    // Assert
    assertEquals("abc", result, "Si se repite 1 vez, el resultado debe ser la misma cadena.");
  }

  @Test
  void testRepeat_string_multiple_times() {
    // Arrange & Act
    String result = StringUtil.repeat("abc", 4);

    // Assert
    assertEquals("abcabcabcabc", result, "El string repetido no coincide con el esperado.");
  }

  @Test
  void testRepeat_string_zero_times() {
    // Arrange & Act
    String result = StringUtil.repeat("abc", 0);

    // Assert
    assertEquals("", result, "Si se repite 0 veces, el resultado debe ser un string vacío.");
  }

  @Test
  void testRepeat_negativeTimes_throwsIllegalArgumentException() {
    // Assert & Act
    assertThrows(IllegalArgumentException.class, () -> {
      StringUtil.repeat("abc", -1);
    });
  }

  //String Empty Test

  @Test
  void testIsEmpty_whenStringIsNotEmpty_returnsFalse() {
    // Arrange & Act
    boolean result = StringUtil.isEmpty("Hola Mundo");

    // Assert
    assertFalse(result, "Una cadena con caracteres no debe considerarse vacía.");
  }

  @Test
  void testIsEmpty_whenStringIsEmpty_returnsTrue() {
    // Arrange & Act
    boolean result = StringUtil.isEmpty("");

    // Assert
    assertTrue(result, "Una cadena vacía \"\" debe considerarse vacía.");
  }

  @Test
  void testIsEmpty_whenStringIsNull_returnsTrue() {
    // Arrange & Act
    boolean result = StringUtil.isEmpty(null);

    // Assert
    assertTrue(result, "Un valor null debe considerarse vacío.");
  }

  @Test
  void testIsEmpty_whenStringContainsOnlySpaces_returnsTrue() {
    // Arrange & Act (Extra: espacios en blanco)
    boolean result = StringUtil.isEmpty("   ");

    // Assert
    assertTrue(result, "Una cadena con solo espacios en blanco debe considerarse vacía tras trim().");
  }
}
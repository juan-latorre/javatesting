package com.javatestprj.javatesting.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilTest {

  @Test
  public void testRepeat_string_multiple_times() {
    // Arrange & Act
    String result = StringUtil.repeat("abc", 4);

    // Assert
    assertEquals("abcabcabcabc", result, "El string repetido no coincide con el esperado.");
  }

  @Test
  public void testRepeat_string_zero_times() {
    // Arrange & Act
    String result = StringUtil.repeat("abc", 0);

    // Assert
    assertEquals("", result, "Si se repite 0 veces, el resultado debe ser un string vacío.");
  }
}
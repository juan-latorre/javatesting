package com.javatestprj.javatesting.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordUtilTest {

    @Test
    void testAssessPassword_whenFewerThan8Characters_returnsWeak() {
        assertEquals(SecurityLevel.WEAK, PassWordUtil.assessPassword("1234567"));
    }

    @Test
    void testAssessPassword_whenOnlyLetters_returnsWeak() {
        assertEquals(SecurityLevel.WEAK, PassWordUtil.assessPassword("abcdefghijk"));
    }

    @Test
    void testAssessPassword_whenLettersAndNumbers_returnsMedium() {
        assertEquals(SecurityLevel.MEDIUM, PassWordUtil.assessPassword("abcd1234"));
    }

    @Test
    void testAssessPassword_whenLettersNumbersAndSymbols_returnsStrong() {
        assertEquals(SecurityLevel.STRONG, PassWordUtil.assessPassword("abcd1234!"));
    }

}

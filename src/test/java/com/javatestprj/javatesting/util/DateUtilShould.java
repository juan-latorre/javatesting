package com.javatestprj.javatesting.util;

import org.junit.jupiter.api.Test;

// Importaciones estáticas para assertThat y CoreMatchers
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

class DateUtilShould {

    // Casuística 1: Divisibles por 400 son bisiestos
    @Test
    void return_true_when_year_is_divisible_by_400() {
        assertThat(DateUtil.isLeapYear(1600), is(true));
        assertThat(DateUtil.isLeapYear(2000), is(true));
        assertThat(DateUtil.isLeapYear(2400), is(true));
    }

    // Casuística 2: Divisibles por 100 pero NO por 400 NO son bisiestos
    @Test
    void return_false_when_year_is_divisible_by_100_but_not_by_400() {
        assertThat(DateUtil.isLeapYear(1700), is(false));
        assertThat(DateUtil.isLeapYear(1800), is(false));
        assertThat(DateUtil.isLeapYear(1900), is(false));
    }

    // Casuística 3: Divisibles por 4 son bisiestos (siempre que no sean múltiplos de 100)
    @Test
    void return_true_when_year_is_divisible_by_4_but_not_by_100() {
        assertThat(DateUtil.isLeapYear(1996), is(true));
        assertThat(DateUtil.isLeapYear(2004), is(true));
        assertThat(DateUtil.isLeapYear(2012), is(true));
    }

    // Casuística 4: NO divisibles por 4 NO son bisiestos
    @Test
    void return_false_when_year_is_not_divisible_by_4() {
        assertThat(DateUtil.isLeapYear(2017), is(false));
        assertThat(DateUtil.isLeapYear(2018), is(false));
        assertThat(DateUtil.isLeapYear(2019), is(false));
    }

}
package com.javatestprj.javatesting.util;

import com.javatestprj.javatesting.player.Dice;
import com.javatestprj.javatesting.player.Player;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void testPlay_whenDiceNumberIsGreaterThanMinNumberToWin_returnsTrue() {
        // Arrange
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(5);

        Player player = new Player(dice, 3); // Necesita sacar más de 3

        // Act
        boolean result = player.play();

        // Assert
        assertTrue(result, "El jugador debería ganar si el número del dado supera el mínimo requerido.");
    }

    @Test
    void testPlay_whenDiceNumberIsLessThanMinNumberToWin_returnsFalse() {
        // Arrange
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(2);

        Player player = new Player(dice, 4); // Necesita sacar más de 4

        // Act
        boolean result = player.play();

        // Assert
        assertFalse(result, "El jugador debería perder si el número del dado es menor al mínimo requerido.");
    }

    @Test
    void testPlay_whenDiceNumberIsEqualToMinNumberToWin_returnsFalse() {
        // Arrange (Caso de borde: casi gana, sacó exactamente el número mínimo)
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(3);

        Player player = new Player(dice, 3); // Necesita estrictamente > 3

        // Act
        boolean result = player.play();

        // Assert
        assertFalse(result, "El jugador no gana si empata con el número mínimo requerido.");
    }

}
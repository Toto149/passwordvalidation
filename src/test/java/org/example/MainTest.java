package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void passwordValidation_shouldReturnTrue_whenAabD1234IsGiven(){
        //GIVEN
        String password = "AabD1234";
        //WHEN
        boolean actual = Main.passwordValidation(password);
        //THEN
        assertTrue(actual);
    }
    @Test
    void passwordValidation_shouldReturnFalse_whenABCDEFGH(){
        //GIVEN
        String password = "ABCDEFGH";
        //WHEN
        boolean actual = Main.passwordValidation(password);
        //THEN
        assertFalse(actual);
    }
    @Test
    void hasNotOverusedPasswords_shouldReturnTrue_whenAabC1234(){
        //GIVEN
        String password = "AabC1234";
        //WHEN
        boolean actual = Main.hasNotOverusedPasswords(password);
        //THEN
        assertTrue(actual);
    }
    @Test
    void hasNotOverusedPasswords_shouldReturnFalse_whenABC12345678(){
        //GIVEN
        String password = "ABC12345678";
        //WHEN
        boolean actual = Main.hasNotOverusedPasswords(password);
        //THEN
        assertFalse(actual);
    }
    @Test
    void hasNumerals_shouldReturnFalse_whenABCdefghIsGiven(){
        //GIVEN
        String password = "ABCdefgh";
        //WHEN
        boolean actual = Main.hasNumerals(password);
        //THEN
        assertFalse(actual);
    }
    @Test
    void hasNumerals_shouldReturnTrue_whenA12BcdefIsGiven(){
        //GIVEN
        String password = "A12Bcdef";
        //WHEN
        boolean actual = Main.hasNumerals(password);
        //THEN
        assertTrue(actual);
    }
    @Test
    void hasBigCharcters_shouldReturnFalse_when1bcd2234IsGiven(){
        //GIVEN
        String password = "1bcd2234";
        //WHEN
        boolean actual = Main.hasBigCharacters(password);
        //THEN
        assertFalse(actual);
    }
    @Test
    void hasBigCharacters_shouldReturnTrue_whenAbce1234IsGiven(){
        //GIVEN
        String password = "Abce1234";
        //WHEN
        boolean actual = Main.hasBigCharacters(password);
        //THEN
        assertTrue(actual);
    }
    @Test
    void hasSmallCharacters_shouldReturnFalse_whenABC12345IsGiven(){
        //GIVEN
        String password = "ABC12345";
        //WHEN
        boolean actual = Main.hasSmallCharacters(password);
        //THEN
        assertFalse(actual);
    }
    @Test
    void hasSmallCharacters_shouldReturnTrue_whenabcD123IsGiven(){
        //GIVEN
        String password = "abcD123";
        //WHEN
        boolean actual = Main.hasSmallCharacters(password);
        //THEN
        assertTrue(actual);
    }
    @Test
    void hasAppropriateLength_shouldReturnFalse_whenAbc123(){
        //GIVEN
        String password = "Abc123";
        //WHEN
        boolean actual = Main.hasAppropriateLength(password);
        //THEN
        assertFalse(actual);
    }
    @Test
    void hasAppropriateLength_shouldReturnTrue_whenABCD1234(){
        //GIVEN
        String password = "ABCD1234";
        //WHEN
        boolean actual = Main.hasAppropriateLength(password);
        //THEN
        assertTrue(actual);
    }



}
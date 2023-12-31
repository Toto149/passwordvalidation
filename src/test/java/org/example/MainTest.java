package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void passwordValidation_shouldReturnTrue_whenAabD123_IsGiven(){
        //GIVEN
        String password = "AabD123_";
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
    @Test
    void hasSpecialCharacters_shouldReturnTrue_whenPasswordWithSpecialCharacterIsGiven(){
        //GIVEN
        String password = "A!BCDa1234";
        //WHEN
        boolean actual = Main.hasSpecialCharacters(password);
        //THEN
        assertTrue(actual);
    }
    @Test
    void hasSpecialCharacters_shouldReturnFalse_whenPasswordWithoutSpecialCharacterIsGiven(){
        //GIVEN
        String password = "ABCDa1234";
        //WHEN
        boolean actual = Main.hasSpecialCharacters(password);
        //THEN
        assertFalse(actual);
    }

    @Test
    void passwordGenerator_shouldReturnValidPassword_whenLenghtIsGreaterEquals8(){
        //GIVEN
        int passwordLength = 8;
        String password = Main.passwordGenerator(passwordLength);
        //WHEN
        boolean actual = Main.passwordValidation(password);
        //THEN
        assertTrue(actual);
    }
    @Test
    void passwordGenerator_shouldReturnNull_whenLengthIs7(){
        //GIVEN
        int passwordLength = 7;
        //WHEN
        String actual = Main.passwordGenerator(passwordLength);
        //THEN
        assertNull(actual);
    }


}
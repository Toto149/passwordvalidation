package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static boolean passwordValidation(String password){
        //Guard Clauses
        if(!hasAppropriateLength(password)) return false;
        if(!hasNumerals(password)) return false;
        if(!hasBigCharacters(password)) return false;
        if(!hasSmallCharacters(password)) return false;
        if(!hasNotOverusedPasswords(password)) return false;
        return true;
    }
    public static boolean hasAppropriateLength(String password) {
        if (password.length() >= 8) {
            return true;
        }
        return false;
    }

    public static boolean hasNumerals(String password) {
        String numerals = "1234567890";
        char[] numbers = numerals.toCharArray();
        for (char number : numbers) {
            if (password.contains(Character.valueOf(number).toString())) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasBigCharacters(String password){
        String bigCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] bigChars = bigCharacters.toCharArray();
        for(char bigChar : bigChars){
            if(password.contains(Character.valueOf(bigChar).toString())){
                return true;
            }
        }
        return false;
    }
    public static boolean hasSmallCharacters(String password){
        String smallCharacters = "abcdefghijklmnopqrstuvwxyz";
        char[] smallChars = smallCharacters.toCharArray();
        for(char smallChar: smallChars){
            if(password.contains(Character.valueOf(smallChar).toString())){
                return true;
            }
        }
        return false;
    }
    public static boolean hasNotOverusedPasswords(String password){
        String[] overusedPasswordSnippets = {"12345678","123456789","Password","Passwort"};
        for(String overusedSnippet : overusedPasswordSnippets) {
            if (password.contains(overusedSnippet)) {
                return false;

            }
        }
        return true;
    }
    public static boolean hasSpecialCharacters(String password){
        String specialCharacters = "^°!+*~#/&%$§/?ß´´.,:;";
        char[] specialChars = specialCharacters.toCharArray();
        for(char specialChar: specialChars){
            if(password.contains(Character.valueOf(specialChar).toString())){
                return true;
            }
        }
        return false;
    }

    public static String passwordGenerator(int passwordLengthOfAtleast8){
        if(passwordLengthOfAtleast8<8){
            System.out.println("Password has to be alteast 8 charcters long");
            return null;
        }
        char[] smallCharacters ="abcdefghijklmnopqrstuvxyz".toCharArray();
        char[] bigCharacters = "ABCDEFGHIJKLMNOPQRSTUVXYZ".toCharArray();
        char[] numerals = "1234567890".toCharArray();
        char[] specialCharacters = "^°!+*~#/&%$§/?ß´.,:;".toCharArray();
        char[][] randomChooseArray = {smallCharacters, bigCharacters, numerals, specialCharacters};

        Random random = new Random();

        String[] password = new String[passwordLengthOfAtleast8];
        String passwordString = String.join("",password);
        while(passwordValidation(passwordString)){
            for(int i = 0; i < passwordLengthOfAtleast8; i++) {
                int chooseFromSmallBigCharsNumeralsSpecialsCharcter = random.nextInt(4);

                if (chooseFromSmallBigCharsNumeralsSpecialsCharcter == 0) {
                    int chooseFromSmallCharacters = random.nextInt(26);
                    password[i] = String.valueOf(randomChooseArray[chooseFromSmallBigCharsNumeralsSpecialsCharcter][chooseFromSmallCharacters]);
                }
                if (chooseFromSmallBigCharsNumeralsSpecialsCharcter == 1) {
                    int chooseFromBigCharacters = random.nextInt(26);
                    password[i] = String.valueOf(randomChooseArray[chooseFromSmallBigCharsNumeralsSpecialsCharcter][chooseFromBigCharacters]);
                }
                if (chooseFromSmallBigCharsNumeralsSpecialsCharcter == 2) {
                    int chooseFromNumerals = random.nextInt(10);
                    password[i] = String.valueOf(randomChooseArray[chooseFromSmallBigCharsNumeralsSpecialsCharcter][chooseFromNumerals]);
                }
                if (chooseFromSmallBigCharsNumeralsSpecialsCharcter == 3) {
                    int chooseFromSpecialCharacters = random.nextInt(20);
                    password[i] = String.valueOf(randomChooseArray[chooseFromSmallBigCharsNumeralsSpecialsCharcter][chooseFromSpecialCharacters]);
                }
            }
        }

        return String.join("",password);


    }


}
package org.example;

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
        if(!hasOverusedPasswords(password)) return false;
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
    public static boolean hasOverusedPasswords(String password){
        String[] overusedPasswordSnippets = {"12345678","123456789","Password","Passwort"};
        for(String overusedSnippet : overusedPasswordSnippets) {
            if (password.contains(overusedSnippet)) {
                return false;

            }
        }
        return true;
    }


}
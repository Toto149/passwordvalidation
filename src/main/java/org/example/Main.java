package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Main{
    public static void main(String[] args) {
        String password = passwordGenerator(8);
        System.out.println(password);
        System.out.println(passwordValidation(password));
    }

    public static boolean passwordValidation(String password){
        //Guard Clauses
        if(!hasAppropriateLength(password)) return false;
        if(!hasNumerals(password)) return false;
        if(!hasBigCharacters(password)) return false;
        if(!hasSmallCharacters(password)) return false;
        if(!hasNotOverusedPasswords(password)) return false;
        return hasSpecialCharacters(password);
    }
    public static boolean hasAppropriateLength(String password) {
        return password.length() >= 8;
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
        String specialCharacters = "_-^°!+*~#/&%$§/?ß´´.,:;";
        char[] specialChars = specialCharacters.toCharArray();
        for(char specialChar: specialChars){
            if(password.contains(Character.valueOf(specialChar).toString())){
                return true;
            }
        }
        return false;
    }

    public static String passwordGenerator(int passwordLength){
        if(passwordLength<8){
            System.out.println("Password has to be alteast 8 charcters long");
            return null;
        }

        Random random = new Random();

        String[] password = new String[passwordLength];
        String passwordString = String.join("",password);
        while(!passwordValidation(passwordString)){
            for(int i = 0; i < passwordLength; i++) {
                int chooseFromRandomArray = random.nextInt(4);
                password[i] = randomStringFromCharArray(chooseFromRandomArray);
            }
            passwordString = String.join("", password);
        }

        return String.join("",password);


    }

    public static String randomStringFromCharArray(int number){
        Random random = new Random();
        char[] smallCharacters ="abcdefghijklmnopqrstuvxyz".toCharArray();
        char[] bigCharacters = "ABCDEFGHIJKLMNOPQRSTUVXYZ".toCharArray();
        char[] numerals = "1234567890".toCharArray();
        char[] specialCharacters = "_-^°!+*~#/&%$§/?ß´.,:;".toCharArray();

        if(number % 4 == 0){
            return String.valueOf(smallCharacters[random.nextInt(smallCharacters.length)]);
        }
        if(number % 4 == 1){
            return String.valueOf(bigCharacters[random.nextInt(bigCharacters.length)]);
        }
        if(number % 4 == 2){
            return String.valueOf(numerals[random.nextInt(numerals.length)]);
        }

        return String.valueOf(specialCharacters[random.nextInt(specialCharacters.length)]);
    }


    //Nothing to see here furher....









    public static String passwordGenerator2(int passwordLength){
        if(passwordLength<8){
            System.out.println("Password has to be alteast 8 charcters long");
            return null;
        }
        char[] smallCharacters ="abcdefghijklmnopqrstuvxyz".toCharArray();
        char[] bigCharacters = "ABCDEFGHIJKLMNOPQRSTUVXYZ".toCharArray();
        char[] numerals = "1234567890".toCharArray();
        char[] specialCharacters = "_-^°!+*~#/&%$§/?ß´.,:;".toCharArray();
        char[][] randomChooseArray = {smallCharacters, bigCharacters, numerals, specialCharacters};
        ArrayList<Integer> listAvailableIndices = new ArrayList<>();

        for(int i = 0; i < passwordLength; i++){
            listAvailableIndices.add(i);
        }

        Random random = new Random();
        int j = 0;

        String[] password = new String[passwordLength];

        for(int i = 0; i < passwordLength; i++){
            int randomNumber = random.nextInt(passwordLength);
            if(j>passwordLength/2){
                for (int number : listAvailableIndices){
                    password[number] = String.valueOf(randomChooseArray[i%4][randomIndiceForCharArray(i)]);
                }

            }
            password[randomNumber] = String.valueOf(randomChooseArray[i % 4][randomIndiceForCharArray(i)]);
            listAvailableIndices.remove(randomNumber);
            j++;
        }
        return String.join("",password);
    }

    public static int randomIndiceForCharArray(int number){
        Random random = new Random();
        char[] smallCharacters ="abcdefghijklmnopqrstuvxyz".toCharArray();
        char[] bigCharacters = "ABCDEFGHIJKLMNOPQRSTUVXYZ".toCharArray();
        char[] numerals = "1234567890".toCharArray();
        char[] specialCharacters = "_-^°!+*~#/&%$§/?ß´.,:;".toCharArray();

        if(number % 4 == 0){
            return random.nextInt(smallCharacters.length);
        }
        if(number % 4 == 1){
            return random.nextInt(bigCharacters.length);
        }
        if(number % 4 == 2){
            return random.nextInt(numerals.length);
        }

        return random.nextInt(specialCharacters.length);
    }

}
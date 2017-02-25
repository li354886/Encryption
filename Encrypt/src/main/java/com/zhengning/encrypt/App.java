package com.zhengning.encrypt;

/**
 * Hello world!
 *
 */
public class App
{
    public static String encrypt(String input) {
        //check invalid input
        if (input == null || input.length() == 0) {
            return input;
        }
        //split the sentence by spaces.
        String[] string = input.split(" ");
        
        //while loop until we heve single word left.
        while (string.length > 1){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < string.length; i++) {
                //append the encrypted word to string builder.
                sb.append(caesarEncrypt(string[i]));
                //concat two near words together.
                if (i % 2 != 0) {
                    sb.append(" ");
                }
            }
            //reassign the new stringbuilder to string.
            string = sb.toString().split(" ");
        }

        //if there is only one single word, this requires additional check
        if (string.length == 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < string.length; i++) {
                sb.append(caesarEncrypt(string[i]));
            }
            string = sb.toString().split(" ");
        }
        //return first element in string array.
        System.out.println("Encryption Succeeded");
        return string[0];
    }

    //general algorithm is to get the caesar encryption which is to shift the letter a specific offset.
    //The strategy is to shift lower case to lower case and upper case to upper case.
    //And leave the other symbols or characters shift from itself and mod 256 which is the number of ASCII characters.
    private static String caesarEncrypt(String s) {
        StringBuilder sb = new StringBuilder();
        char[] array = s.toCharArray();
        //for each character in this array do our encryption algorithm
        for (int i = 0; i < array.length; i++) {
            int offset;
            int index;
            char encrypt;
            //if is a lower case, then we shift result should also be a lower case
            if (Character.isLowerCase(array[i])) {
                offset = array[i] - 'a';
                index = (offset + 4);
                encrypt = (char)('a' + index % 26);
            } else if (Character.isUpperCase(array[i])){ //same logic for uppercase
                offset = array[i] - 'A';
                index = (offset + 4);
                encrypt = (char)('A' + index % 26);
            } else { //additional check on other characters and symbols
                encrypt = (char)((array[i] + 4) % 256);
            }
            sb.append(encrypt);
        }
        //return the encrypted result
        return sb.toString();
    }

    public static String decrypt(String s, int len) {
        if (s == null || s.length() == 0) {
            return s;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(encrypt("How are you doing man, what day is today"));
    }
}



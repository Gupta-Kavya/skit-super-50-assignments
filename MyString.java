/*
@filename - Mystring.java
@description - String methods implementation class
@author - Kavya Gupta
*/


import java.util.Arrays;

// writing custom "Mystring" class to perform operations on strings

public class MyString {

    private String value = new String("");

    // Constructor to initialize the string

    MyString(String value) {
        this.value = value;
    }

    // 1. Append function
    String append(String str1) {
        this.value = value + str1;
        return value;
    }

    // 2. countWords function

    int countWords() {
        if (value == null || value.isEmpty()) {
            return 0;
        }

        int count = 0;
        boolean inWord = false;

        for (int i = 0; i < value.length(); i++) {
            char characterOfString = value.charAt(i);

            // Check if the character is a letter or digit
            if (Character.isLetterOrDigit(characterOfString)) {
                if (!inWord) {
                    count++;
                    inWord = true;
                }
            } else {
                inWord = false;
            }
        }

        return count;
    }

    // 3. isPalindrome function

    boolean isPalindrome() {
        int left = 0;
        int right = value.length() - 1;

        while (right > left) {
            if (value.charAt(right) != value.charAt(left)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // 4. maxRepeat() function

    void getMaxRepeat() {
        int[] hash_array = new int[256]; // Declaring the hash array

        // Populating the hash array

        for (int i = 0; i < value.length(); i++) {

            char characterOfString = Character.toLowerCase(value.charAt(i));

            hash_array[characterOfString]++;

        }

        int answerIndex = -1;
        int answerFrequency = 0;

        for (int i = 0; i < hash_array.length; i++) {
            if (answerFrequency < hash_array[i]) {
                answerFrequency = hash_array[i];
                answerIndex = i;
            }
        }

        if (answerIndex != -1) {
            System.out.println((char) (answerIndex) + " -> " + answerFrequency);
        } else {
            System.out.println("No letters found!");
        }
    }

    // 5. splice(int start, int length) function

    String splice(int start, int length) {

        if (value == null || start < 0 || length < 0 || start >= value.length()) {
            return value;
        }

        return value = value.substring(0, start) + value.substring(start + length);

    }

    // 6. split(String pattern) function

    String[] split() {
        int words = countWords();
        String[] split_array = new String[words];
        int index = 0;

        String temp = "";

        for (int i = 0; i < value.length(); i++) {
            char characterOfString = value.charAt(i);

            if (characterOfString == ' ') {
                if (!temp.isEmpty()) {
                    split_array[index++] = temp;
                    temp = "";
                }
            } else {
                temp = temp + characterOfString;
            }
        }

        if (!temp.isEmpty()) {
            split_array[index++] = temp;
        }

        return split_array;
    }

    // 7. reverse() function

    String reverse() {

        String reversed = "";

        for (int i = value.length() - 1; i >= 0; i--) {
            reversed = reversed + value.charAt(i);

        }

        return value = reversed;
    }

    // 8. shift(int n) function

    String shift(int numberOfCharacters) {

        numberOfCharacters = numberOfCharacters % value.length(); // Handling the case for n > string length

        return value.substring(value.length() - numberOfCharacters)
                + value.substring(0, value.length() - numberOfCharacters);
    }

    // 9. sort() function

    String sort() {
        char[] string_to_arr = value.toCharArray();
        Arrays.sort(string_to_arr);
        return value = new String(string_to_arr);
    }

    // 10. replace(char a, char b) function

    String replace(char oldChar, char newChar) {
        // This function replace only character values, as i am overloading it further
        // for string also.
        String result = "";
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == oldChar) {
                result += newChar;
            } else {
                result += value.charAt(i);
            }
        }
        return value = result;
    }

    // 10. replace(String a, String b) function

    String replace(String oldString, String newString) {
        // Replaces substring value also
        if (oldString == null || oldString.isEmpty())
            return value;

        String result = "";
        int start = 0;
        int index;

        while ((index = value.indexOf(oldString, start)) != -1) {
            result += value.substring(start, index);
            result += newString;
            start = index + oldString.length();
        }

        result += value.substring(start);
        return value = result;
    }

}

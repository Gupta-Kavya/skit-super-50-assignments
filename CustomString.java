/*
@filename - CustomString.java
@description - String Based Functions
@author - Kavya Gupta
*/

package Assignment_2;

public class CustomString {

    // Function to count number of consonants in a string.

    int countConsonants(String value) {

        if (value == null || value.isEmpty()) {
            return 0;
        }

        value = value.toLowerCase();
        int noOfConsonants = 0;

        for (int i = 0; i < value.length(); i++) {
            char character = value.charAt(i);
            if (character != 'a' && character != 'e' && character != 'i' && character != 'o' && character != 'u'
                    && character >= 'a' && character <= 'z') {

                noOfConsonants++;

            }
        }

        return noOfConsonants;

    }

    // Expand characters in a string followed by digits.

    String expandString(String value) {
        if (value == null || value.isEmpty()) {
            System.err.println("Error: Input string cannot be null or empty.");
            return "";
        }

        if (value.length() % 2 != 0) {
            System.err.println("Error: Please enter valid string with every characters followed by digits.");
            return "";
        }

        String expandedVersion = "";

        for (int i = 0; i < value.length() - 1; i = i + 2) {

            if (Character.isDigit(value.charAt(i + 1))) {
                expandedVersion += String.valueOf(value.charAt(i)).repeat(value.charAt(i + 1) - '0');
            } else {
                System.err.println("Error: Not a valid form.");
                return "";
            }

        }

        return expandedVersion;

    }

    // Compress string.

    String compressString(String value) {
        if (value == null || value.isEmpty()) {
            System.err.println("Error: Input string cannot be null or empty.");
            return "";
        }

        String compressedVersion = "";
        int count = 1;

        for (int i = 0; i < value.length(); i++) {
            if (i + 1 < value.length() && value.charAt(i) == value.charAt(i + 1)) {
                count++;
            } else {
                compressedVersion += value.charAt(i) + "" + count;
                count = 1;
            }
        }

        return compressedVersion;
    }

    // Function to calculate maximum length of non-repeating characters in a string.

    int longestNonRepeatingSubstring(String value) {

        if (value == null || value.isEmpty()) {
            System.err.println("Error: Input string cannot be null or empty.");
            return 0;
        }

        int[] frequency_array = new int[256];

        int left = 0;
        int right = 0;

        int maxLength = 0;

        while (right < value.length()) {
            frequency_array[value.charAt(right)]++;

            while (frequency_array[value.charAt(right)] > 1) {
                frequency_array[value.charAt(left)]--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);

            right++;
        }

        return maxLength;
    }

}

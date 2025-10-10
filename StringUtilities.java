/*
@filename - StringUtilities.java
@description - This class contains string-based utility functions including:
               1. Counting consonantss in a string.
               2. Expanding characters in a string followed by digits.
               3. Compressing consecutive characters with their frequencies.
               4. Finding the length of the longest non-repeating substring.
               5. Converting snake_case strings to camelCase format.
               6. Counting unique palindromic substrings in a string.
@author - Kavya Gupta
*/


package Assignment_2;

public class StringUtilities {

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

        // Solved by Sliding window approach

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

    // Function to convert string from snake case format to camel case

    String snakeToCamelCase(String value) {
        if (value == null || value.isEmpty()) {
            System.err.println("Error: Input string cannot be null or empty.");
            return "";
        }

        String camelCase = "";
        boolean makeUpperCase = false;

        for (int i = 0; i < value.length(); i++) {
            char currentChar = value.charAt(i);

            if (currentChar == '_') {
                // Next letter should be uppercase
                makeUpperCase = true;
            } else {
                if (makeUpperCase) {
                    camelCase += Character.toUpperCase(currentChar);
                    makeUpperCase = false;
                } else {
                    camelCase += currentChar;
                }
            }
        }

        return camelCase;
    }

    // Function to count number of unique palindrmes ina string

    int countUniquePalindromes(String value) {
        if (value == null || value.isEmpty()) {
            System.err.println("Error: Input string cannot be null or empty.");
            return 0;
        }

        String[] uniquePalindromes = new String[value.length() * value.length()];
        int count = 0;

        for (int start = 0; start < value.length(); start++) {
            for (int end = start + 1; end <= value.length(); end++) {
                String substring = value.substring(start, end);

                if (isPalindrome(substring)) {
                    boolean alreadyPresent = false;
                    for (int i = 0; i < count; i++) {
                        if (uniquePalindromes[i].equals(substring)) {
                            alreadyPresent = true;
                            break;
                        }
                    }

                    if (!alreadyPresent) {
                        uniquePalindromes[count] = substring;
                        count++;
                    }
                }
            }
        }

        return count;
    }

    // Helper function to check palindrome

    boolean isPalindrome(String value) {
        int left = 0;
        int right = value.length() - 1;

        while (left < right) {
            if (value.charAt(left) != value.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}

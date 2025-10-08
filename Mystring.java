/**
@filename - Mystring.java
@description - String methods implementation class
@author - Kavya Gupta
*/

import java.util.Arrays;
import java.util.Scanner;

// writing custom "Mystring" class to perform operations on strings

public class Mystring {

    private String value = new String("");

    // Constructor to initialize the string

    Mystring(String value) {
        this.value = value;
    }

    // 1. Append function
    // Description: Appends the newString provided by the user to the existing
    // string. The method should remember the appended result.

    String append(String str1) {
        this.value = value + str1; // Concatenting str1 to value every time.
        return value;
    }

    // 2. countWords function
    // Description: Counts the total number of words in the current string

    int countWords() {
        if (value == null || value.isEmpty()) {
            return 0;
        }

        boolean space = false;
        int count = 0;

        for (int i = 0; i < value.length(); i++) {

            // Here i am checking that if i am between two words or not.
            // When i came to a word after traversing all the spaces i increase the count
            // ans make space = true and make sure that i traverse whole word and again when
            // space comes then i make space = false means i have counted one whole word.

            if (value.charAt(i) == ' ') {
                space = false;
            }

            if (!space && value.charAt(i) != ' ') {
                count++;
                space = true;
            }

        }

        return count;
    }

    // 3. isPalindrome function
    // Description: Checks if the current string is a palindrome. A palindrome is a
    // word, phrase, or sequence that reads the same backward as forward.

    boolean isPalindrome() {
        int left = 0;
        int right = value.length() - 1;

        // comparing the first and second half of the word. If any character came
        // different then return false else true.

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
    // Description: Finds and returns the character that appears the most frequently
    // in the current string.

    void maxRepeat() {
        int[] arr = new int[256]; // Declaring the hash array

        Arrays.fill(arr, 0); // Inititialize the array with value 0

        // Populating the hash array

        for (int i = 0; i < value.length(); i++) {

            char ch = Character.toLowerCase(value.charAt(i));

            arr[ch]++;

        }

        // Checking for max element by comparing frequency in hash array

        int ansIndex = -1;
        int ansFrequency = 0;

        for (int i = 0; i < arr.length; i++) {
            if (ansFrequency < arr[i]) {
                ansFrequency = arr[i];
                ansIndex = i;
            }
        }

        if (ansIndex != -1) {
            System.out.println((char) (ansIndex) + " -> " + ansFrequency);
        } else {
            System.out.println("No letters found!");
        }
    }

    // 5. splice(int start, int length) function
    // Description: Removes a substring from the current string starting at index
    // start and of length length.

    String splice(int start, int length) {

        if (value == null || start < 0 || length < 0 || start >= value.length()) {
            return value;
        }

        // I just remove the substring from (start + 1 to start + length - 1 ) and rest
        // add all.

        return value = value.substring(0, start) + value.substring(start + length);

    }

    // 6. split(String pattern) function
    // Description: Splits the current string into an array of words.

    String[] split() {
        int words = countWords();
        String[] arr = new String[words];
        int index = 0;

        String temp = "";

        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);

            // if i encounterd space and als there is some value in temp then it means i
            // traverse one whole word, so i added it into arr and reinitialize the temp;
            // If no such i will keep appending in temp.

            if (ch == ' ') {
                if (!temp.isEmpty()) {
                    arr[index++] = temp;
                    temp = "";
                }
            } else {
                temp = temp + ch;
            }
        }

        // to insert last word left.

        if (!temp.isEmpty()) {
            arr[index++] = temp;
        }

        return arr;
    }

    // 7. reverse() function
    // Description: Reverses the current string

    String reverse() {

        char[] arr = value.toCharArray(); // convert our string to character array

        int left = 0; // initializing left pointer to start of the array
        int right = arr.length - 1; // initializing right pointer to end of the array

        // start traversing and perform swapping at every step

        while (right > left) {

            char temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;

            left++;
            right--;
        }

        // put the reversed array to string

        String reversed = "";

        for (int i = 0; i < arr.length; i++) {
            reversed = reversed + arr[i];
            if (i != arr.length - 1) {
                reversed = reversed + " ";
            }
        }

        return value = reversed;
    }

    // 8. shift(int n) function
    // Description: Moves the first n characters from the start to the end of the
    // current string.

    String shift(int n) {

        n = n % value.length(); //  Handling the case for n > string length

        return value.substring(value.length() - n) + value.substring(0, value.length() - n);
    }

    // 9. sort() function
    // Description: Sorts the characters of the current string in alphabetical
    // order.

    String sort() {
        char[] arr = value.toCharArray(); // converting string to character array
        Arrays.sort(arr); // sorting the array - used predefined array sort function as it sorts in
                          // optimized way according to size of the array.
        return value = new String(arr);
    }

    // 10. replace(char a, char b) function
    // Description: Replaces all occurrences of character a with character b in the
    // current string

    String replace(char oldChar, char newChar) {
        // This function replace only character values, as i am overloading it further for string also.
        String result = "";
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == oldChar) { // every time when ever i ge the occurenece of "a" in "value" then i replace it
                                      // with "b".
                result += newChar;
            } else {
                result += value.charAt(i);
            }
        }
        return value = result;
    }

    // 10. replace(String a, String b) function
    // Description: Replaces all occurrences of character a with character b in the
    // current string

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
/**
@filename - Prog1.java
@description - String methods implementation
@author - Kavya Gupta
*/

import java.util.Arrays;
import java.util.Scanner;

// writing custom "Mystring" class to perform operations on strings

class Mystring {

    String str = new String("");

    // Constructor to initialize the string

    Mystring(String str) {
        this.str = str;
    }

    // 1. Append function
    // Description: Appends the newString provided by the user to the existing
    // string. The method should remember the appended result.

    String append(String str1) {
        this.str = str + str1; // Concatenting str1 to str every time.
        return str;
    }

    // 2. countWords function
    // Description: Counts the total number of words in the current string

    int countWords() {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        boolean space = false;
        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            // Here i am checking that if i am between two words or not.
            // When i came to a word after traversing all the spaces i increase the count
            // ans make space = true and make sure that i traverse whole word and again when
            // space comes then i make space = false means i have counted one whole word.

            if (str.charAt(i) == ' ') {
                space = false;
            }

            if (!space && str.charAt(i) != ' ') {
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
        int right = str.length() - 1;

        // comparing the first and second half of the word. If any character came
        // different then return false else true.

        while (right > left) {
            if (str.charAt(right) != str.charAt(left)) {
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

        for (int i = 0; i < str.length(); i++) {

            char ch = Character.toLowerCase(str.charAt(i));

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

        if (str == null || start < 0 || length < 0 || start >= str.length()) {
            return str;
        }

        // I just remove the substring from (start + 1 to start + length - 1 ) and rest
        // add all.

        return str = str.substring(0, start) + str.substring(start + length);

    }

    // 6. split(String pattern) function
    // Description: Splits the current string into an array of words.

    String[] split() {
        int words = countWords();
        String[] arr = new String[words];
        int index = 0;

        String temp = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

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

        char[] arr = str.toCharArray(); // convert our string to character array

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

        return str = reversed;
    }

    // 8. shift(int n) function
    // Description: Moves the first n characters from the start to the end of the
    // current string.

    String shift(int n) {

        n = n % str.length(); //  Handling the case for n > string length

        return str.substring(str.length() - n) + str.substring(0, str.length() - n);
    }

    // 9. sort() function
    // Description: Sorts the characters of the current string in alphabetical
    // order.

    String sort() {
        char[] arr = str.toCharArray(); // converting string to character array
        Arrays.sort(arr); // sorting the array - used predefined array sort function as it sorts in
                          // optimized way according to size of the array.
        return str = new String(arr);
    }

    // 10. replace(char a, char b) function
    // Description: Replaces all occurrences of character a with character b in the
    // current string

    String replace(char a, char b) {
        // This function replace only character values, as i am overloading it further for string also.
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a) { // every time when ever i ge the occurenece of "a" in "str" then i replace it
                                      // with "b".
                result += b;
            } else {
                result += str.charAt(i);
            }
        }
        return str = result;
    }

    // 10. replace(String a, String b) function
    // Description: Replaces all occurrences of character a with character b in the
    // current string

    String replace(String a, String b) {
        // Replaces substring value also
        if (a == null || a.isEmpty())
            return str;

        String result = "";
        int start = 0;
        int index;

        while ((index = str.indexOf(a, start)) != -1) {
            result += str.substring(start, index);
            result += b;
            start = index + a.length();
        }

        result += str.substring(start);
        return str = result;
    }

}

public class Prog1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");

        // Here i am taking an input from user for the main string
        String st = sc.nextLine();

        Mystring str = new Mystring(st);

        // Here providing options to user for performing different operations on string
        // using switch - case

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Append");
            System.out.println("2. CountWords");
            System.out.println("3. Replace (char)");
            System.out.println("4. Replace (String)");
            System.out.println("5. isPalindrome");
            System.out.println("6. Splice");
            System.out.println("7. Split");
            System.out.println("8. MaxRepeatingCharacter");
            System.out.println("9. Sort");
            System.out.println("10. Shift");
            System.out.println("11. Reverse");
            System.out.println("12. Exit");
            System.out.print("Enter choice (1-12): ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter string to append: ");
                    String toAppend = sc.nextLine();
                    System.out.println("Result: " + str.append(toAppend));
                    break;

                case 2:
                    System.out.println("Word count: " + str.countWords());
                    break;

                case 3:
                    System.out.print("Enter character to replace: ");
                    char oldChar = sc.next().charAt(0);
                    System.out.print("Enter replacement character: ");
                    char newChar = sc.next().charAt(0);
                    System.out.println("Result: " + str.replace(oldChar, newChar));
                    break;

                case 4:
                    System.out.print("Enter substring to replace: ");
                    String oldStr = sc.nextLine();
                    System.out.print("Enter replacement string: ");
                    String newStr = sc.nextLine();
                    System.out.println("Result: " + str.replace(oldStr, newStr));
                    break;

                case 5:
                    System.out.println("Is palindrome? " + str.isPalindrome());
                    break;

                case 6:
                    System.out.print("Enter start index: ");
                    int start = sc.nextInt();
                    System.out.print("Enter length: ");
                    int length = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Result: " + str.splice(start, length));
                    break;

                case 7:
                    System.out.println("Split result: " + Arrays.toString(str.split()));
                    break;

                case 8:
                    System.out.print("Max repeating character: ");
                    str.maxRepeat();
                    break;

                case 9:
                    System.out.println("Sorted string: " + str.sort());
                    break;

                case 10:
                    System.out.print("Enter shift value: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Shifted string: " + str.shift(n));
                    break;

                case 11:
                    System.out.println("Reversed string: " + str.reverse());
                    break;

                case 12:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

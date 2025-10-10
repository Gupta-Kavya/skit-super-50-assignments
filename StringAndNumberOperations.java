/*
@filename - StringAndNumberOperations.java
@description - String & Number Operations usage (Menu Driven Program with Input Type Validation)
@author - Kavya Gupta
*/

package Assignment_2;

import java.util.Scanner;

public class StringAndNumberOperations {

    public static void main(String[] args) {
        NumberUtilities number = new NumberUtilities();
        StringUtilities string = new StringUtilities();
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        String choiceInput;

        do {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Fibonacci Number");
            System.out.println("2. Check Prime Number");
            System.out.println("3. Binary to Decimal");
            System.out.println("4. Convert Number to Word");
            System.out.println("5. Count Consonants in String");
            System.out.println("6. Expand String (char followed by digit)");
            System.out.println("7. Compress String");
            System.out.println("8. Longest Non-Repeating Substring");
            System.out.println("9. Convert Snake Case to Camel Case");
            System.out.println("10. Count Unique Palindromes");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choiceInput = sc.nextLine();

            // Validate that menu choice is numeric
            if (choiceInput.matches("\\d+")) {
                choice = Integer.parseInt(choiceInput);
            } else {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter number for Fibonacci: ");
                    String fibInput = sc.nextLine();
                    if (fibInput.matches("\\d+")) {
                        int fib = Integer.parseInt(fibInput);
                        System.out.println("Fibonacci: " + number.findFibonacciNumber(fib));
                    } else {
                        System.out.println("Invalid input! Please enter an integer.");
                    }
                    break;

                case 2:
                    System.out.print("Enter number to check prime: ");
                    String primeInput = sc.nextLine();
                    if (primeInput.matches("\\d+")) {
                        int prime = Integer.parseInt(primeInput);
                        System.out.println(prime + (number.isPrime(prime) ? " is prime" : " is not prime"));
                    } else {
                        System.out.println("Invalid input! Please enter an integer.");
                    }
                    break;

                case 3:
                    System.out.print("Enter binary number: ");
                    String binary = sc.nextLine();
                    if (!binary.isEmpty()) {
                        System.out.println("Decimal: " + number.binaryToDecimal(binary));
                    } else {
                        System.out.println("Invalid input! Please enter a valid string.");
                    }
                    break;

                case 4:
                    System.out.print("Enter number to convert to words: ");
                    String numInput = sc.nextLine();
                    if (numInput.matches("\\d+")) {
                        int num = Integer.parseInt(numInput);
                        System.out.println("In Words: " + number.convertNumberToWords(num));
                    } else {
                        System.out.println("Invalid input! Please enter an integer.");
                    }
                    break;

                case 5:
                    System.out.print("Enter string to count consonants: ");
                    String strConsonants = sc.nextLine();
                    if (!strConsonants.isEmpty()) {
                        System.out.println("Consonants: " + string.countConsonants(strConsonants));
                    } else {
                        System.out.println("Invalid input! Please enter a string.");
                    }
                    break;

                case 6:
                    System.out.print("Enter string to expand: ");
                    String strExpand = sc.nextLine();
                    if (!strExpand.isEmpty()) {
                        System.out.println("Expanded String: " + string.expandString(strExpand));
                    } else {
                        System.out.println("Invalid input! Please enter a string.");
                    }
                    break;

                case 7:
                    System.out.print("Enter string to compress: ");
                    String strCompress = sc.nextLine();
                    if (!strCompress.isEmpty()) {
                        System.out.println("Compressed String: " + string.compressString(strCompress));
                    } else {
                        System.out.println("Invalid input! Please enter a string.");
                    }
                    break;

                case 8:
                    System.out.print("Enter string for longest non-repeating substring: ");
                    String strLongest = sc.nextLine();
                    if (!strLongest.isEmpty()) {
                        System.out.println("Length: " + string.longestNonRepeatingSubstring(strLongest));
                    } else {
                        System.out.println("Invalid input! Please enter a string.");
                    }
                    break;

                case 9:
                    System.out.print("Enter snake_case string: ");
                    String strSnake = sc.nextLine();
                    if (!strSnake.isEmpty()) {
                        System.out.println("CamelCase: " + string.snakeToCamelCase(strSnake));
                    } else {
                        System.out.println("Invalid input! Please enter a string.");
                    }
                    break;

                case 10:
                    System.out.print("Enter string to count unique palindromes: ");
                    String strPalindrome = sc.nextLine();
                    if (!strPalindrome.isEmpty()) {
                        System.out.println("Unique Palindromes: " + string.countUniquePalindromes(strPalindrome));
                    } else {
                        System.out.println("Invalid input! Please enter a string.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}

/*
@filename - StringAndNumberOperations.java
@description - String & Number Operations usage (Menu Driven Program)
@author - Kavya Gupta
*/

package Assignment_2;

import java.util.Scanner;

public class StringAndNumberOperations {

    public static void main(String[] args) {
        NumberUtilities number = new NumberUtilities();
        StringUtilities string = new StringUtilities();
        Scanner sc = new Scanner(System.in);

        int choice;
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
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter number for Fibonacci: ");
                    int fib = sc.nextInt();
                    System.out.println("Fibonacci: " + number.findFibonacciNumber(fib));
                    break;

                case 2:
                    System.out.print("Enter number to check prime: ");
                    int prime = sc.nextInt();
                    System.out.println(prime + (number.isPrime(prime) ? " is prime" : " is not prime"));
                    break;

                case 3:
                    System.out.print("Enter binary number: ");
                    String binary = sc.next();
                    System.out.println("Decimal: " + number.binaryToDecimal(binary));
                    break;

                case 4:
                    System.out.print("Enter number to convert to words: ");
                    int num = sc.nextInt();
                    System.out.println("In Words: " + number.convertNumberToWords(num));
                    break;

                case 5:
                    System.out.print("Enter string to count consonants: ");
                    String strConsonants = sc.nextLine();
                    System.out.println("Consonants: " + string.countConsonants(strConsonants));
                    break;

                case 6:
                    System.out.print("Enter string to expand: ");
                    String strExpand = sc.nextLine();
                    System.out.println("Expanded String: " + string.expandString(strExpand));
                    break;

                case 7:
                    System.out.print("Enter string to compress: ");
                    String strCompress = sc.nextLine();
                    System.out.println("Compressed String: " + string.compressString(strCompress));
                    break;

                case 8:
                    System.out.print("Enter string for longest non-repeating substring: ");
                    String strLongest = sc.nextLine();
                    System.out.println("Length: " + string.longestNonRepeatingSubstring(strLongest));
                    break;

                case 9:
                    System.out.print("Enter snake_case string: ");
                    String strSnake = sc.nextLine();
                    System.out.println("CamelCase: " + string.snakeToCamelCase(strSnake));
                    break;

                case 10:
                    System.out.print("Enter string to count unique palindromes: ");
                    String strPalindrome = sc.nextLine();
                    System.out.println("Unique Palindromes: " + string.countUniquePalindromes(strPalindrome));
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

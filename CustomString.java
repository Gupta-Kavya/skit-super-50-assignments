/*
@filename - CustomString.java
@description - String methods implementation usage
@author - Kavya Gupta
*/

import java.util.Arrays;
import java.util.Scanner;



public class CustomString {
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

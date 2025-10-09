/*
@filename - CustomNumber.java
@description - Number Based Functions
@author - Kavya Gupta
*/

package Assignment_2;

public class CustomNumber {

    // Function to find nth fibonaaci number in a sequence

    int findFibonacciNumber(int number) {
        if (number == 0 || number == 1) {
            return number;
        }

        return findFibonacciNumber(number - 1) + findFibonacciNumber(number - 2);
    }

    // Function to check that a number is prime or not

    boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Function to convert a binary number string to decimal number.

    int binaryToDecimal(String binaryNumber) {
        int decimalNumber = 0;

        for (int i = binaryNumber.length() - 1; i >= 0; i--) {
            decimalNumber += (binaryNumber.charAt(i) - '0') * Math.pow(2, binaryNumber.length() - i - 1);
        }

        return (int) decimalNumber;
    }
}

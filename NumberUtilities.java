/*
@filename - NumberUtilities.java
@description - This class contains number-based utility functions including:
               1. Finding the nth Fibonacci number in a sequence.
               2. Checking if a number is prime.
               3. Converting a binary number string to decimal.
               4. Converting an integer number to its English words representation.
@author - Kavya Gupta
*/


package Assignment_2;

public class NumberUtilities {

    // Function to find nth fibonacci number in a sequence

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

    // Function to convert number into words.

    String convertNumberToWords(int number) {
        if (number == 0) {
            return "zero";
        }

        if (number < 0) {
            return "minus " + convertNumberToWords(-number);
        }

        String[] ones = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
                "seventeen", "eighteen", "nineteen" };

        String[] tens = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

        String words = "";

        if ((number / 1000000) > 0) {
            words += convertNumberToWords(number / 1000000) + " million ";
            number %= 1000000;
        }

        if ((number / 1000) > 0) {
            words += convertNumberToWords(number / 1000) + " thousand ";
            number %= 1000;
        }

        if ((number / 100) > 0) {
            words += convertNumberToWords(number / 100) + " hundred ";
            number %= 100;
        }

        if (number > 0) {
            if (number < 20) {
                words += ones[number];
            } else {
                words += tens[number / 10];
                if ((number % 10) > 0) {
                    words += " " + ones[number % 10];
                }
            }
        }

        return words.trim();
    }

}
/*
@filename - NumberUtilities.java
@description - This class contains number-based utility functions including:
               1. Finding the nth Fibonacci number in a sequence.
               2. Checking if a number is prime.
               3. Converting a binary number string to decimal.
               4. Converting an integer number to its English words representation.
@author - Kavya Gupta
*/


package Assignment_2;

public class NumberUtilities {

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

    // Fuction to convert number into words.

    String convertNumberToWords(int number) {
        if (number == 0) {
            return "zero";
        }

        if (number < 0) {
            return "minus " + convertNumberToWords(-number);
        }

        String[] ones = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
                "seventeen", "eighteen", "nineteen" };

        String[] tens = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

        String words = "";

        if ((number / 1000000) > 0) {
            words += convertNumberToWords(number / 1000000) + " million ";
            number %= 1000000;
        }

        if ((number / 1000) > 0) {
            words += convertNumberToWords(number / 1000) + " thousand ";
            number %= 1000;
        }

        if ((number / 100) > 0) {
            words += convertNumberToWords(number / 100) + " hundred ";
            number %= 100;
        }

        if (number > 0) {
            if (number < 20) {
                words += ones[number];
            } else {
                words += tens[number / 10];
                if ((number % 10) > 0) {
                    words += " " + ones[number % 10];
                }
            }
        }

        return words.trim();
    }

}

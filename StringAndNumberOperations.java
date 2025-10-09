/*
@filename - StringAndNumberOperations.java
@description - String & Number Operations usage
@author - Kavya Gupta
*/

package Assignment_2;

public class StringAndNumberOperations {
    public static void main(String[] args) {
        CustomNumber number = new CustomNumber();
        CustomString string = new CustomString();


        System.out.println(number.findFibonacciNumber(6));
        System.out.println(number.isPrime(6));
        System.out.println(number.binaryToDecimal("1011"));


        System.out.println(string.countConsonants("hello world"));
        System.out.println(string.expandString("a1b4c3"));
        System.out.println(string.compressString("aabcccdeee"));
        System.out.println(string.longestNonRepeatingSubstring("pwwkew"));
    }
}

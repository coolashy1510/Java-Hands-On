package com.io.Java11.dev.code.ForChallenge;

public class DigitSumChallenge {
    public static void main(String[] args) {
       System.out.println( "The sum of Digits is " + sumDigits(1234));
        System.out.println( "The sum of Digits is " + sumDigits(-125));
        System.out.println( "The sum of Digits is " + sumDigits(4));
        System.out.println( "The sum of Digits is " + sumDigits(32123));
    }

    public static int sumDigits (int number) {

        if ( number < 0 ) {
            return -1;
        }

        int sum =0;

        while (number > 9) {
            sum += (number %10);
            number = number / 10;
        }
        sum += number;

        return sum;
    }
}

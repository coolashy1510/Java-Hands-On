package com.io.Java11.dev.code.ForChallenge;

public class PrimeNumber {
    public static void main(String[] args) {

//        System.out.println("0 " + (isPrime(0) ? "Is a ": "NOT a ") + "PRIME Number");
//        System.out.println("1 " + (isPrime(1) ? "Is a ": "NOT a ") + "PRIME Number");
//        System.out.println("2 " + (isPrime(2) ? "Is a ": "NOT a ") + "PRIME Number");
//        System.out.println("3 " + (isPrime(3) ? "Is a ": "NOT a ") + "PRIME Number");
//
//        System.out.println("8 " + (isPrime(8) ? "Is a ": "NOT a ") + "PRIME Number");
//        System.out.println("17 " + (isPrime(17) ? "Is a ": "NOT a ") + "PRIME Number");

        int primeCounter = 0;
        for (int i =10; i <=1000; i++) {
            if (isPrime(i)) {
                System.out.println(i + " is a prime Number");
                primeCounter++;

                if (primeCounter == 3) {
                    break;
                }

            }
        }

    }

    /**
     * isPrime method to check if a number is prime or not.
     *
     * @param wholeNumber
     * @return
     */
    public static boolean isPrime (int wholeNumber) {
        if (wholeNumber <= 2) {
            return (wholeNumber == 2 );
        }

        for (int divisor = 2; divisor <= wholeNumber/2 ; divisor++) {
            if ( wholeNumber % divisor == 0) {
                return  false;
            }
        }
        return true;
    }
}

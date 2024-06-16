package com.io.Java11.ForChallenge;

public class GreatestCommonDivisor {

    public static void main(String[] args) {
System.out.println(getGreatestCommonDivisor(1010,10));
    }

    public static int getGreatestCommonDivisor (int first, int second) {
        if (first < 10 || second < 10) {
            return -1;
        }

        int smallestValue = Math.min(first, second);

        int greatestCommonDivisor = 0;

        for(int i =1; i <= smallestValue; i++) {
            if(first % i == 0 && second % i == 0) {
                System.out.println(i);
                greatestCommonDivisor = i;
            }
        }
        return greatestCommonDivisor;
    }
}

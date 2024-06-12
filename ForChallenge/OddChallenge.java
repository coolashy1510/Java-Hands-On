package com.io.Java11.ForChallenge;



    public class OddChallenge {

        public static void main(String[] args) {
            System.out.println(sumOdd(1,11));
        }
        public static boolean isOdd (int number) {
            if (number < 0) {
                return false;
            }

            System.out.println("number % 3 -> " +number % 3);
            System.out.println("number / 3 -> " + number / 3);
            return number % 2 != 0;
        }

        public static int sumOdd (int start, int end) {
            int sumOfNumbers = 0;
            if (start < 0 || end < 0 || end < start ) {
                return -1;
            }

            for (int i = start; i <=end; i++ ) {
                System.out.println("Value of i is "+ i );
                if (isOdd(i)) {
                    sumOfNumbers += i;
                }
            }
            return sumOfNumbers;
        }

    }


package com.io.Java11.ForChallenge;

public class LastDigitChecker {

    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(9,99,999));
    }

    public static boolean hasSameLastDigit (int first, int second, int third) {
        boolean isFirstValid = isValid(first);
        boolean isSecondValid = isValid(second);
        boolean isThirdValid = isValid(third);

        if (!isFirstValid || !isSecondValid || !isThirdValid) {
            return false;
        }

        int firstRightDigit = first % 10;
        System.out.println(firstRightDigit);

        int secondRightDigit = second % 10;
        System.out.println(secondRightDigit);

        int thirdRightDigit = third % 10;
        System.out.println(thirdRightDigit);

        return firstRightDigit == secondRightDigit || firstRightDigit == thirdRightDigit || secondRightDigit == thirdRightDigit;
    }

    public static boolean isValid(int number) {
          return number > 9 && number < 1001;
    }
}

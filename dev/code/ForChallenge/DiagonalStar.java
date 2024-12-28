package com.io.Java11.dev.code.ForChallenge;

public class DiagonalStar
{
    public static void main(String[] args) {
        printSquareStar(5);
    }

    private static final String STAR = "*";
    private static final String SPACE = " ";
    public static void printSquareStar(int number) {
        // Check if the input number is less than 5
        // If it is, print an error message and return
        // This is done to ensure that the number is valid and can be used to create a square star pattern
        if (number < 5) {
            
            // Print an error message indicating that the input value is invalid
            System.out.print("Invalid Value");
            
            // Return from the function to stop further execution
            return;
        }
        // Loop through each row (i) and column (j) of the square
        for (int i=1; i<=number; i++) {
            for (int j =1; j<=number; j++) {
                // Check conditions for where to print a star
                // Conditions are: first row, last row, first column, last column, or on the diagonal
                boolean isFirstRowOrColumn = i == 1 || j == 1;
                boolean isLastRowOrColumn = i == number || j == number;
                boolean isDiagonal = (i == j) || (j == (number - i + 1));

                // If any of the conditions are true, print a star
                if (isFirstRowOrColumn || isLastRowOrColumn || isDiagonal) {
                    System.out.print(STAR);
                } 
                // If none of the conditions are true, print a space
                else {
                    System.out.print(SPACE);
                }
            }
            // After each row, print a new line to move to the next row
            System.out.println();
        }
    }
}

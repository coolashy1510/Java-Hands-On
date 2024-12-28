package com.io.Java11.dev.code.ForChallenge;

public class FlourPackProblem {
    public static void main(String[] args) {
System.out.println(canPack(2,1, 5));
    }

    /**
     * If the sum is greater than goal, ensure that only full bags are used towards the goal amount.
     * For example, if goal = 9, bigCount = 2, and smallCount = 0, the method should return false since each big bag is
     * 5 kilos and cannot be divided. However, if goal = 9, bigCount = 1, and smallCount = 5, the method should return
     * true because of 1 full bigCount bag and 4 full smallCount bags equal goal, and it's okay if there are additional
     * bags left over.
     * <p>
     * 2,2,12 -> true
     * <p>
     * 1,5,9  -> true
     * <p>
     * 1,0,9  -> false
     *
     * @param bigCount - big flour bags (5 kilos each)
     * @param smallCount - small flour bags (1 kilo each)
     * @param goal - the goal amount of kilos of flour needed to assemble a package
     * @return - The method should return true if it is possible to make a package with goal kilos of flour.
     */
    private static final int BIG_WEIGHT = 5;

    public static boolean canPack (int bigCount, int smallCount, int goal) {

        if(bigCount <0 || smallCount <0 || goal <0) {
            return false;
        }

        int totalBigWeight  = bigCount * BIG_WEIGHT;

        boolean result = false;
        if (totalBigWeight >= goal) {
           int remainingWeight = goal % BIG_WEIGHT;
            if (smallCount >= remainingWeight) {
                result = true;
            }
        } else {
            if (smallCount >= goal - totalBigWeight) {
                result = true;
            }
        }
        return result;

    }
}

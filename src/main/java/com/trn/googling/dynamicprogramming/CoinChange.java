package com.trn.googling.dynamicprogramming;

/**
 * Coin Change | DP-7
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
 * how many ways can we make the change? The order of coins doesn’t matter.
 *
 * For example, for N = 4 and S = {1,2,3},
 * there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
 * So output should be 4.
 *
 * For N = 10 and S = {2, 5, 3, 6},
 * there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 * So the output should be 5.
 */
public class CoinChange {

    private static int result = 0;

    private static int calculateChange(int[] coins, int index, int total){
        if(total == 0){
            return 1;
        }

        if(total < 0){
            return 0;
        }


        if(index < 0 && total > 0){
            return 0;
        }

        return calculateChange(coins, index - 1, total) + calculateChange(coins, index , total - coins[index]);
    }

    public static void main(String[] args) {
        System.out.println("The result is => "+ calculateChange(new int[]{2, 5, 3, 6}, 3, 10));
    }
}

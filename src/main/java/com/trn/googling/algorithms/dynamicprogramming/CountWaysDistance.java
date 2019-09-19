package com.trn.googling.algorithms.dynamicprogramming;

/**
 * Count number of ways to cover a distance
 * Given a distance ‘dist, count total number of ways to cover the distance with 1, 2 and 3 steps.
 *
 * ```
 *
 * Input:  n = 3
 * Output: 4
 * Below are the four ways
 *  1 step + 1 step + 1 step
 *  1 step + 2 step
 *  2 step + 1 step
 *  3 step
 *
 * Input:  n = 4
 * Output: 7
 *
 * ```
 */
public class CountWaysDistance {

    private static int countWays(int n){

        int[] lookup = new int[n + 1];
        lookup[0] = 1;
        lookup[1] = 1;
        lookup[2] = 2;

        for(int i = 3; i <= n; i++){
            lookup[i] = lookup[i - 1] + lookup[i - 2] + lookup[i - 3];
        }

        return lookup[n];
    }

    public static void main(String[] args) {
        System.out.println("the result is => "+ countWays(4));
    }
}

package com.trn.googling.dynamicprogramming;

/**
 * Subset Sum Problem | DP-25
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 *
 * Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output:  True  //There is a subset (4, 5) with sum 9.
 */
public class SubsetSum {

    private static boolean subsetSum(int[] arr, int sum){
        // this matrix contains column as sum from 0 to sum and rows as the number of arrays...
        boolean[][] lookup = new boolean[arr.length][sum + 1];

        //fill sum zero as true for first column; because zero can be obtained by empty set as well
        for(int j = 0; j < arr.length; j++){
            lookup[j][0] = true;
        }

        //fill first row
        for(int j = 1; j <= sum; j++){
            if(arr[0] == j){
                lookup[0][j] = true;
            } else {
                lookup[0][j] = false;
            }
        }

        // now fill every row one by one
        for(int i = 1; i < arr.length; i++){

            for(int j = 1; j <= sum; j++){
                if(lookup[i - 1][j]){
                    lookup[i][j] = true;
                    continue;
                }
                if(j - arr[i] < 0){
                    lookup[i][j] = false;
                    continue;
                }
                lookup[i][j] = lookup[i - 1][j - arr[i]];
            }
        }


        return lookup[arr.length - 1][sum];
    }

    public static void main(String[] args) {
        System.out.println("result is => "+ subsetSum(new int[]{3, 34, 4, 12, 5, 2}, 36));
    }
}

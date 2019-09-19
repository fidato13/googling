package com.trn.googling.algorithms.dynamicprogramming;

/**
 * Partition problem
 * Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same.
 *
 * arr[] = {1, 5, 11, 5}
 * Output: true
 * The array can be partitioned as {1, 5, 5} and {11}
 *
 * arr[] = {1, 5, 3}
 * Output: false
 * The array cannot be partitioned into equal sum sets.
 */
public class PartitionProblem {

    private static boolean canPartition(int[] nums) {

        int total = 0;
        for(int num : nums){
            total += num;
        }

        //check if the total is odd then there is no way that there could be two subsets of equal sum
        if(total % 2 != 0){
            return false;
        }

        total = total / 2;

        boolean[][] lookup = new boolean[nums.length + 1][total + 1];

        // fill first row
        for(int j = 1 ; j <= total; j++){
            lookup[0][j] = false;
        }

        //fill first column
        for(int i = 0; i <= nums.length; i++){
            lookup[i][0] = true;
        }

        for(int i = 1; i <= nums.length; i++){

            for(int j = 1; j <= total; j++){

                if(nums[i - 1] > j){
                    lookup[i][j] = lookup[i - 1][j];
                    continue;
                }

                lookup[i][j] = lookup[i - 1][j] || lookup[i - 1][j - nums[i - 1]];

            }
        }

        return lookup[nums.length][total];


    }

    public static void main(String[] args) {
        System.out.println("The result is => "+canPartition(new int[]{1, 5, 11, 5}));
    }
}

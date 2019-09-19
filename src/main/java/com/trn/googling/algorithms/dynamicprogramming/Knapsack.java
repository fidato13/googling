package com.trn.googling.algorithms.dynamicprogramming;

/**
 * 0-1 Knapsack Problem | DP-10
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 *
 *
 */
public class Knapsack {

    //private static int[] weight = new int[]{10,20,30};
    //private static int[] value = new int[]{60,100,120};

    private static int[] weight = new int[]{5,4,6,3};
    private static int[] value = new int[]{10,40,30,50};

    private static int calculateRecursive(int capacity, int index){

        if(capacity <= 0 || index >= value.length || capacity < weight[index]){
            return 0;
        }

        return Math.max(value[index] + calculateRecursive(capacity - weight[index], index + 1) ,
                calculateRecursive(capacity, index + 1)
                );
    }

    private static int calculateIterative(int capacity){

        int[][] lookup = new int[weight.length + 1][capacity + 1];

        //fill first row, i.e. when we have no object to pick up in a bag of varying capacity
        for(int j = 0; j <= capacity; j++){
            lookup[0][j] = 0;
        }

        // fill first column i.e. varying objects but we have a bag of capacity zero
        for(int i = 0; i < weight.length; i++){
            lookup[i][0] = 0;
        }

        for(int i = 1; i <= weight.length; i++){
            for(int j = 1; j <= capacity; j++){

                if(j - weight[i - 1] < 0){
                    lookup[i][j] = lookup[i - 1][j];
                    continue;
                }

                lookup[i][j] = Math.max(
                        lookup[i - 1][j],
                       value[i - 1] + lookup[i - 1][j - weight[i - 1]]
                );
            }
        }

        return lookup[weight.length][capacity];
    }

    public static void main(String[] args) {
        System.out.println("THe knapsack recursive value is => "+ calculateRecursive(10, 0));
        System.out.println("THe knapsack iterative value is => "+ calculateIterative(10));
    }
}

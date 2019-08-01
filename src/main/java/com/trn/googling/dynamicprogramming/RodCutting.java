package com.trn.googling.dynamicprogramming;

/**
 * The rod-cutting problem is the following. Given a rod of length n inches and a
 * table of prices pi for i D 1;2; : : : ;n, determine the maximum revenue rn obtainable
 * by cutting up the rod and selling the pieces. Note that if the price pn for a rod
 * of length n is large enough, an optimal solution may require no cutting at all.
 * Consider the case when n D 4. Figure 15.2 shows all the ways to cut up a rod
 * of 4 inches in length, including the way with no cuts at all. We see that cutting a
 * 4-inch rod into two 2-inch pieces produces revenue p2 Cp2 D 5C5 D 10, which
 * is optimal.
 *
 * ```
 * length i 1 2 3 4 5 6 7 8 9 10
 * price pi 1 5 8 9 10 17 17 20 24 30
 * ```
 */
public class RodCutting {

    // price[i] = price of rod of i inches
    private static int[] price = new int[]{0,1,5,8,9,10,17,17,20,24,30};

    private static int maximizeRodPriceRecursive(int n){

        if(n == 0){
            return 0;
        }

        int localPrice = 0;
        for(int i = 1; i <= n ; i++){
            localPrice = Math.max(localPrice, price[i] + maximizeRodPriceRecursive(n - i));
        }

        return localPrice;
    }

    private static int maximizeRodPriceDP(int n){
        int[] lookup = new int[price.length];
        lookup[0] = 0;

        for(int j = 1; j <= n; j++){
            int localPrice = Integer.MIN_VALUE;

            for(int i = 1; i <= j; i++){
                localPrice = Math.max(localPrice, price[i] + lookup[j - i]);
            }

            lookup[j] = localPrice;
        }

        return lookup[n];
    }

    public static void main(String[] args) {

        System.out.println("value => "+ maximizeRodPriceDP(4));
    }
}

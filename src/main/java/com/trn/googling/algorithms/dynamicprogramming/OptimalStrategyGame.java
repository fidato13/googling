package com.trn.googling.algorithms.dynamicprogramming;

/**
 * Optimal Strategy for a Game | DP-31
 * Problem statement: Consider a row of n coins of values v1 . . . vn, where n is even. We play a game against an opponent by alternating turns. In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin. Determine the maximum possible amount of money we can definitely win if we move first.
 *
 * Note: The opponent is as clever as the user.
 *
 * Let us understand the problem with few examples:
 *
 * 1. 5, 3, 7, 10 : The user collects maximum value as 15(10 + 5)
 *
 * 2. 8, 15, 3, 7 : The user collects maximum value as 22(7 + 15)
 *
 * Does choosing the best at each move give an optimal solution?
 *
 * No. In the second example, this is how the game can finish:
 *
 * 1.
 * …….User chooses 8.
 * …….Opponent chooses 15.
 * …….User chooses 7.
 * …….Opponent chooses 3.
 * Total value collected by user is 15(8 + 7)
 * 2.
 * …….User chooses 7.
 * …….Opponent chooses 8.
 * …….User chooses 15.
 * …….Opponent chooses 3.
 * Total value collected by user is 22(7 + 15)
 * So if the user follows the second game state, maximum value can be collected although the first move is not the best.
 */
public class OptimalStrategyGame {
    // just copy pasted , need to understand how bottom up solution works
    // Returns optimal value possible that a player
    // can collect from an array of coins of size n.
    // Note than n must be even
    static int optimalStrategyOfGame(int arr[], int n)
    {
        // Create a table to store solutions of subproblems
        int table[][] = new int[n][n];
        int gap, i, j, x, y, z;

        // Fill table using above recursive formula.
        // Note that the tableis filled in diagonal
        // fashion (similar to http:// goo.gl/PQqoS),
        // from diagonal elements to table[0][n-1]
        // which is the result.
        for (gap = 0; gap < n; ++gap) {
            for (i = 0, j = gap; j < n; ++i, ++j) {

                // Here x is value of F(i+2, j),
                // y is F(i+1, j-1) and z is
                // F(i, j-2) in above recursive formula
                x = ((i + 2) <= j) ? table[i + 2][j] : 0;
                y = ((i + 1) <= (j - 1)) ? table[i + 1][j - 1] : 0;
                z = (i <= (j - 2)) ? table[i][j - 2] : 0;

                table[i][j] = Math.max(arr[i] + Math.min(x, y),
                        arr[j] + Math.min(y, z));
            }
        }

        return table[0][n - 1];
    }

    private static int optimalGameRecursive(int[] arr, int rangeStart, int rangeEnd){

        if(rangeEnd - rangeStart < 0){
            return 0;
        }

        if(rangeEnd - rangeStart == 0){
            return arr[rangeEnd];
        }

        if(rangeEnd - rangeStart == 1){
            return Math.max(arr[rangeStart], arr[rangeEnd]);
        }

        return Math.max(
                arr[rangeStart] + Math.min(
                        optimalGameRecursive(arr, rangeStart + 1, rangeEnd - 1),
                        optimalGameRecursive(arr, rangeStart + 2, rangeEnd))
                ,
                arr[rangeEnd] + Math.min(
                        optimalGameRecursive(arr, rangeStart, rangeEnd - 2),
                        optimalGameRecursive(arr, rangeStart + 1, rangeEnd - 1)
                )
        );

    }

    // just copy pasted , need to understand how bottom up solution works
    public static int solve(int[] A) {
        int[][] MV = new int[A.length][A.length];

        for (int interval = 0; interval < A.length; interval++) {
            for (int i = 0, j = interval; j < A.length; i++, j++) {
                // a = MV(i+2,j) - Alice chooses i Bob chooses i+1
                // b = MV(i+1,j-1)- Alice chooses i , Bob chooses j OR
                // Alice chooses j , Bob chooses i
                // c = MV(i,j-2)- Alice chooses j , Bob chooses j-1
                int a, b, c;
                if (i + 2 <= j)
                    a = MV[i + 2][j];
                else
                    a = 0;
                //////////////////////////////////
                if (i + 1 <= j - 1)
                    b = MV[i + 1][j - 1];
                else
                    b = 0;
                //////////////////////////////////
                if (i <= j - 2)
                    c = MV[i][j-2];
                else
                    c = 0;
                //////////////////////////////////
                MV[i][j] = Math
                        .max(A[i] + Math.min(a, b), A[j]+ Math.min(b, c));
            }
        }
        return MV[0][A.length - 1];
    }

    public static void main(String[] args) {
        int arr1[] = { 8, 15, 3, 7 };
        int n = arr1.length;
        solve(arr1);
//        System.out.println("" + optimalStrategyOfGame(arr1, n));
//        System.out.println("" + optimalGameRecursive(arr1, 0, n - 1));
//
//        int arr2[] = { 2, 2, 2, 2 };
//        n = arr2.length;
//        System.out.println("" + optimalStrategyOfGame(arr2, n));
//        System.out.println("" + optimalGameRecursive(arr2, 0, n - 1));
//
//        int arr3[] = { 20, 30, 2, 2, 2, 10 };
//        n = arr3.length;
//        System.out.println("" + optimalStrategyOfGame(arr3, n));
//        System.out.println("" + optimalGameRecursive(arr3, 0, n - 1));
//
//        int arr4[] = { 12,3,6,9,17,11,34,56,6,5};
//        n = arr4.length;
//        System.out.println("" + optimalStrategyOfGame(arr4, n));
//        System.out.println("" + optimalGameRecursive(arr4, 0, n - 1));
    }
}

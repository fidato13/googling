package com.trn.googling.algorithms.dynamicprogramming;

/**
 * ```
 * Definition 1 The Longest Common Subsequence (LCS) problem is as follows. We are given
 * two strings: string S of length n, and string T of length m. Our goal is to produce their longest
 * common subsequence: the longest sequence of characters that appear left-to-right (but not necessarily
 * in a contiguous block) in both strings.
 * For example, consider:
 * S = ABAZDC
 * T = BACBAD
 * In this case, the LCS has length 4 and is the string ABAD. Another way to look at it is we are finding
 * a 1-1 matching between some of the letters in S and some of the letters in T such that none of the
 * edges in the matching cross each other.
 * ```
 */
public class LongestCommonSubsequence {

    private static int lcsRecursive(char[] arr1, int i, char[] arr2, int j){

        // if we have exhausted either of the array
        if(i == -1 || j == -1){
            return 0;
        }

        if(arr1[i] == arr2[j]){
            return 1 + lcsRecursive(arr1, i - 1, arr2, j - 1);
        }

        return Math.max(lcsRecursive(arr1, i - 1, arr2, j), lcsRecursive(arr1, i , arr2, j - 1));
    }

    // a bottom up approach
    private static int lcsDP(char[] arr1, char[] arr2){

        int m = arr1.length , n = arr2.length;

        // define a lookup table
        int[][] lookup = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(arr1[i - 1] == arr2[j - 1]){
                    lookup[i][j] = 1 + lookup[i - 1][j - 1];
                } else {
                    lookup[i][j] = Math.max(lookup[i - 1][j], lookup[i][j - 1]);
                }
            }
        }

        return lookup[m][n];
    }

    public static void main(String[] args) {
        String str1 = "ABAZDC";
        String str2 = "BACBAD";

        int resultRecursive = lcsRecursive(str1.toCharArray(), str1.length() - 1, str2.toCharArray(), str2.length() - 1);
        System.out.println("The result Recursive is => "+ resultRecursive);

        int resultDP = lcsDP(str1.toCharArray(), str2.toCharArray());
        System.out.println("The result DP is => "+ resultDP);
    }
}

package com.trn.googling.dynamicprogramming;

/**
 * ```
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * longest-increasing-subsequence
 *
 * Input  : arr[] = {3, 10, 2, 1, 20}
 * Output : Length of LIS = 3
 * The longest increasing subsequence is 3, 10, 20
 *
 * Input  : arr[] = {3, 2}
 * Output : Length of LIS = 1
 * The longest increasing subsequences are {3} and {2}
 *
 * Input : arr[] = {50, 3, 10, 7, 40, 80}
 * Output : Length of LIS = 4
 * The longest increasing subsequence is {3, 7, 40, 80}
 * ```
 */
public class LongestIncreasingSubsequence {

    //private static int[] sequence = new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80};
    private static int[] sequence = new int[]{3, 10, 2, 1, 20};

    private static int lisDP(){
        int[] result = new int[sequence.length]; // result array; this contains a value which is the LIS length at every index... i.e. at index 3rd, the LIS is the value denoted

        // as initially every index itself is LIS of length 1
        for(int i = 0; i < result.length; i++){
            result[i] = 1;
        }

        // the bigger loop or the loop which tells the index which will be evaluated against every index from 0 to j to find if the value at index j can extend the global LIS till that point
        for(int j = 1 ; j < sequence.length; j++){

            for(int i = 0; i < j; i++){

                if(sequence[j] > sequence[i]){
                    if(result[i] + 1 >= result[j]){
                        result[j] = result[i] + 1;
                    }
                }
            }
        }

        int globalMax = 1;
        for(int entry : result){
            if(entry > globalMax){
                globalMax = entry;
            }
        }

        return globalMax;
    }

    public static void main(String[] args) {
        int result = lisDP();
        System.out.println("the result => "+result);
    }
}

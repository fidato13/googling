package com.trn.googling.algorithms.dynamicprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Problem : https://www.geeksforgeeks.org/longest-even-length-substring-sum-first-second-half/
 *
 * Longest Even Length Substring such that Sum of First and Second Half is same
 * Given a string ‘str’ of digits, find the length of the longest substring of ‘str’, such that the length of the substring is 2k digits and sum of left k digits is equal to the sum of right k digits.
 * Examples :
 *
 * Input: str = "123123"
 * Output: 6
 * The complete string is of even length and sum of first and second
 * half digits is same
 *
 * Input: str = "1538023"
 * Output: 4
 * The longest substring with same first and second half sum is "5380"
 *
 */
public class LongestSubstringEvenLength {

    private static Logger LOG = LoggerFactory.getLogger(LongestSubstringEvenLength.class);

    /**
     * Brute Force solution for this problem would be to consider substring of even length,i.e. 2,4,6 ... and for those lengths, start from 0 index to j (decided by length of substrting)
     * then check that substring if it has left half and right half equal or not.
     *
     * Does this look like a dp problem ?!
     *
     * yes it does
     *      - as it has optimal substructure i.e. all subproblems os of same nature; find a shorter substring and comapre their first half and second half
     *      - as it has overlapping subproblems i.e. we are computing the sums again and again of already computed/covered sequences. For example:
     *          suppose in an iteration/subproblem we process a substring of length 6, it's starting index is i & ending index j , so when in another iteration
     *          if we have a substring of length 4 , starting index i , ending index (j - 2) , then in this case we will `again` be calculating the length between those indexes.
     *          But ideally we should note and think that when we calculated from index i to j for length 6, we can then derive any of the length between those two indexes
     *          so, if i to j - 2 ' s length is required then simply subtract , (length from i to j ) - (element at j ) - (element at j - 1) instead of recalculating from scratch
     *
     *          Since in Dynamic programming, we have to have the two above properties and we have to basically remove the recalculation or rather the overalpping subproblems calculation,
     *          so we should get a hint here about how to proceed for this problem.
     *
     *          So if we maintain a two dimensional array such that s[i][j] , would represent the sum from index of i to j , that would help in calculation and we can improve upon the brute force solution
     *
     *
     */

    int result = 0;

    public Integer longestSubstringLength(Integer[] inputArr){

        int inputLength = inputArr.length;

        int[][] lengthArray = new int[inputLength][inputLength];

        //fill the length array
        for(int i = 0; i < inputLength; i++){
            lengthArray[i][i] = inputArr[i];
        }

        for(int lengthSubstring = 2; lengthSubstring <= inputLength; lengthSubstring++){

            for(int i = 0; i < inputLength - lengthSubstring + 1; i++){
                int j = i + lengthSubstring - 1;
                int k = lengthSubstring / 2;

                //sum of left and right
                lengthArray[i][j] = lengthArray[i][j-k] + lengthArray[j-k+1][j];

                if(lengthSubstring % 2 == 0 && lengthArray[i][j-k] == lengthArray[j-k+1][j] && lengthSubstring > result){
                    result = lengthSubstring;
                }
            }

        }


        return result;
    }

    public static void main(String[] args) {

        LongestSubstringEvenLength longestSubstringEvenLength = new LongestSubstringEvenLength();

        String input = "1538023";

        Integer[] arr = Arrays.stream(input.split("")).map(x -> Integer.parseInt(x)).toArray(Integer[]::new);

        int finalResult = longestSubstringEvenLength.longestSubstringLength(arr);

        LOG.info("Result is => "+ finalResult);


    }

}

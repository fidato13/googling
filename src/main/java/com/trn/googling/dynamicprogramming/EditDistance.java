package com.trn.googling.dynamicprogramming;

/** https://www.youtube.com/watch?v=MiqoA-yF-0M
 * Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 *
 * Insert
 * Remove
 * Replace
 * All of the above operations are of equal cost.
 *
 * ```
 * Input:   str1 = "geek", str2 = "gesek"
 * Output:  1
 * We can convert str1 into str2 by inserting a 's'.
 *
 * Input:   str1 = "cat", str2 = "cut"
 * Output:  1
 * We can convert str1 into str2 by replacing 'a' with 'u'.
 *
 * Input:   str1 = "sunday", str2 = "saturday"
 * Output:  3
 * Last three and first characters are same.  We basically
 * need to convert "un" to "atur".  This can be done using
 * below three operations.
 * Replace 'n' with 'r', insert t, insert a
 * ```
 */
public class EditDistance {

    private static int calculateMinDistance(String string1, String string2){
        int[][] subProblemMatrix = new int[string2.length() + 1][string1.length() + 1];

        // fill first column
        for(int i = 0; i < subProblemMatrix.length; i++){
            subProblemMatrix[i][0] = i;
        }

        //fill first row
        for(int j = 0; j < subProblemMatrix[0].length; j++){
            subProblemMatrix[0][j] = j;
        }

        for(int i = 1; i < subProblemMatrix.length; i++){
            for(int j = 1; j < subProblemMatrix[0].length; j++){
                if(string1.charAt(j - 1) != string2.charAt(i - 1)){
                    subProblemMatrix[i][j] = 1 + Math.min(subProblemMatrix[i - 1][j - 1] , Math.min(subProblemMatrix[i - 1][j], subProblemMatrix[i][j - 1]));
                } else {
                    subProblemMatrix[i][j] = subProblemMatrix[i - 1][j - 1];
                }
            }
        }

        return subProblemMatrix[string2.length()][string1.length()];

    }

    public static void main(String[] args) {
        System.out.println("The result is => "+calculateMinDistance("sunday","saturday"));
    }
}

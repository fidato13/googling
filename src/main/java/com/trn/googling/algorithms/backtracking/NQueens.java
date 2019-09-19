package com.trn.googling.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * NQueens problem. i.e. place the N - Queens on an ( N * N ) chess board so that no queen is under attack.
 */
public class NQueens {

    private static List<List<Integer>> result = new ArrayList<>();

    private static boolean leftDiagonalValid(int column, int row, int newChoiceColumn, int newChoiceRow, int n){

        if(row == newChoiceRow && column == newChoiceColumn){
            return false;
        }

        int tempUpperRow = row - 1;
        int tempUpperColumn = column - 1;

        //check upper left
        while(tempUpperRow >= 0 && tempUpperColumn >= 0){
            if(tempUpperRow == newChoiceRow && tempUpperColumn == newChoiceColumn){
                return false;
            }

            tempUpperRow--;
            tempUpperColumn--;
        }


        int tempLowerRow = row + 1;
        int tempLowerColumn = column + 1;

        //check lower right
        while(tempLowerRow <= n - 1 && tempLowerColumn <= n - 1){
            if(tempLowerRow == newChoiceRow && tempLowerColumn == newChoiceColumn){
                return false;
            }

            tempLowerColumn++;
            tempLowerRow++;
        }

        return true;
    }

    private static boolean rightDiagonalValid(int column, int row, int newChoiceColumn, int newChoiceRow, int n){

        if(row == newChoiceRow && column == newChoiceColumn){
            return false;
        }

        int tempUpperRow = row - 1;
        int tempUpperColumn = column + 1;

        //check upper right
        while(tempUpperRow >= 0 && tempUpperColumn <= n - 1){
            if(tempUpperRow == newChoiceRow && tempUpperColumn == newChoiceColumn){
                return false;
            }

            tempUpperRow--;
            tempUpperColumn++;
        }


        int tempLowerRow = row + 1;
        int tempLowerColumn = column - 1;

        //check lower right
        while(tempLowerRow <= n - 1 && tempLowerColumn >= 0){
            if(tempLowerRow == newChoiceRow && tempLowerColumn == newChoiceColumn){
                return false;
            }

            tempLowerColumn--;
            tempLowerRow++;
        }

        return true;
    }

    private static boolean isValidPlacement(List<Integer> columnPlacements, int n){
        if(columnPlacements.size() == 1){
            return true;
        }

        int currentChoiceColumn = columnPlacements.get(columnPlacements.size() - 1);
        int currentChoiceRow = columnPlacements.size() - 1; //0 index based

        //check the current choice against other already placed queens
        for(int row = 0; row < columnPlacements.size() - 1; row++){

            //if not the same row - this check will be taken care by earlier method as we are not inserting in the same row ever... solveNQueens(n, row + 1, columnPlacements, result); ...see row + 1 there

            //if not same column
            if(columnPlacements.get(row) == currentChoiceColumn){
                return false;
            }

            // if diagonally problem
            int placedQueenColumn = columnPlacements.get(row);
            //create left and right diagonal indices and then check if currentChoice is contained within those
            if(!leftDiagonalValid(placedQueenColumn, row, currentChoiceColumn, currentChoiceRow, n) ||
                    !rightDiagonalValid(placedQueenColumn, row, currentChoiceColumn, currentChoiceRow, n)
            ) {
                return false;
            }

        }

        return true;
    }

    private static void solveNQueens(Integer n, Integer row, List<Integer> columnPlacements){

        if(row == n + 1){
            result.add(new ArrayList<>(columnPlacements));
            return;
        }

        // go thru every column for the current iteration(row) and try to place
        for(int col = 0; col < n; col++){
            columnPlacements.add(col);
            if(isValidPlacement(columnPlacements, n)){
                // if this is a valid placement , then recurse or in other words go on to the next row
                solveNQueens(n, row + 1, columnPlacements);
            }

            // since now we tried out this possibility and if this was a valid one, we would have gone on recursively for next rows and the result
            // would have been accumulated ...now time to remove our choice
            columnPlacements.remove(columnPlacements.size() - 1); // remove the last added element
        }

    }

    public static void main(String[] args) {
        int n = 8;
        solveNQueens(n, 1, new ArrayList<>());
        System.out.println("The result => "+ result.size());

    }
}

package com.trn.googling.dynamicprogramming;

/**
 * Given a two dimensional cost matrix cost[][] of order m * n ,where cost[i][j] respresents the cost passing thru cell (i,j) . Total cost to reach
 *  a particular cell is the sum of costs of all the cells in that path (including the starting and final cell). We can only move either downward or rightward
 *  . i.e. f we are at cell (i,j) then we can either go to cell (i, j + 1) or to (i + 1, j )
 *
 *  write a function that returns the minumum cost of moving from the top-left cell to the bottom-right cell  of the matrix
 */
public class MinCostPath {

    int turnCount = 0;
    public boolean divisorGame(int N) {

        turnCount++;

        if(N <= 1) {
            if(turnCount % 2 != 0){ //alice's turn
                return false;
            } else {
                return true;
            }
        }


        int chosen = chooseLargest(N);
        if(chosen == -1){
            return divisorGame(-1);
        }
        else return divisorGame(N - chosen);
    }



    private int chooseLargest(int N){
        if(N <= 1) {
            return -1;
        }

        for(int i = N - 1; i > 0; i--){
            if(N % i == 0){
                return i;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        MinCostPath minCostPath = new MinCostPath();
        Boolean result = minCostPath.divisorGame(5);
        System.out.println("result => "+ result);
    }
}

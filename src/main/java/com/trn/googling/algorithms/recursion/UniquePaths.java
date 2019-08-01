package com.trn.googling.algorithms.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UniquePaths {

    private static Logger LOG = LoggerFactory.getLogger(UniquePaths.class);

    int maxColumn = -1;
    int maxRow = -1;

    public int uniquePaths(int m, int n) {

        maxColumn = m;
        maxRow = n;

        return helper(0,0);
    }

    private int helper(int m, int n){
        if(m > maxColumn || n > maxRow){
            return 0;
        }

        return 1 + helper(m + 1, n) + helper(m, n + 1);
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        int result = uniquePaths.uniquePaths(3,2);

        LOG.info("Result => "+ result);
    }
}

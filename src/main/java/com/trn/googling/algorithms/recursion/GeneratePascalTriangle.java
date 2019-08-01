package com.trn.googling.algorithms.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneratePascalTriangle {

    private static Logger LOG = LoggerFactory.getLogger(GeneratePascalTriangle.class);

    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {
        if(numRows > 0){
            generateRow(numRows);
        }

        return result;
    }

    private List<Integer> generateRow(int rowNum){

        if(rowNum == 1) {
            List<Integer> currentRow = Arrays.asList(1);
            result.add(currentRow);
            return currentRow;
        }

        List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);

        List<Integer> previousRow = generateRow(rowNum - 1);

        for(int j = 1; j < rowNum - 1; j++ ){
            currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
        }

        currentRow.add(1);


        result.add(currentRow);
        return currentRow;
    }

    public static void main(String[] args) {
        GeneratePascalTriangle generatePascalTriangle = new GeneratePascalTriangle();
        List<List<Integer>> res = generatePascalTriangle.generate(5);

        LOG.info("res =>  "+res);


    }
}

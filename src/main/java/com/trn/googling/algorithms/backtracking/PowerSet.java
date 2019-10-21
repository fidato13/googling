package com.trn.googling.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate all subsets of a set
 */
public class PowerSet {

    private static List<List<Integer>> result = new ArrayList<>();

    private static int[] inputArray = new int[]{1,2,3};

    private static void generatePowerSet(List<Integer> localSubset, int index){

        if(index == inputArray.length){
            result.add(new ArrayList<>(localSubset));
            return;
        }

        localSubset.add(inputArray[index]);
        generatePowerSet(new ArrayList<>(localSubset), index+1);
        localSubset.remove(localSubset.size() - 1);
        generatePowerSet(new ArrayList<>(localSubset), index+1);

    }

    public static void main(String[] args) {

        generatePowerSet(new ArrayList<>(), 0);

        System.out.println("The result => "+ result);

        String s = "abcdef";
    }
}

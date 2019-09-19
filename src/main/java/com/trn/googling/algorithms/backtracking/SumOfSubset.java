package com.trn.googling.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers and a sum, find all subsets of the integers from the set which add up to this sum
 */
public class SumOfSubset {

    private static int totalSum = 30;

    private static int[] inputArray = new int[]{5,10,12,13,15,18};

    private static List<List<Integer>> result = new ArrayList<>();

    private static int sum(List<Integer> list){
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    private static boolean isValid(List<Integer> selectedSubset){
        if(sum(selectedSubset) > totalSum ){
            return false;
        }
        return true;
    }

    private static void generateSubsets(List<Integer> selectedSubset, int remainingSubsetSum, final int index){

        if(sum(selectedSubset) == totalSum){
            result.add(new ArrayList<>(selectedSubset));
            return;
        }

        if(index == inputArray.length || remainingSubsetSum + sum(selectedSubset) < totalSum ){
            return;
        }

        //make a choice
        selectedSubset.add(inputArray[index]);

        //if still valid
        if(isValid(selectedSubset)){
            generateSubsets(new ArrayList<>(selectedSubset), remainingSubsetSum - inputArray[index], index + 1);
        }

        selectedSubset.remove(selectedSubset.size() - 1);

        generateSubsets(new ArrayList<>(selectedSubset), remainingSubsetSum - inputArray[index], index + 1);


    }

    public static void main(String[] args) {

        generateSubsets(new ArrayList<>(), 73, 0);
        System.out.println("The result => "+result);
    }

}

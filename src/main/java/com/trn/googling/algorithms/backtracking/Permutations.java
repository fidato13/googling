package com.trn.googling.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Generate all permutations of the string
 */
public class Permutations {

    private static List<List<Integer>> result = new ArrayList<>();

    private static List<Integer> inputArrayList = Arrays.asList(1,2,3);

    private static void generatePermutations(List<Integer> permutation, int index){

        if(index == inputArrayList.size()){
            result.add(new ArrayList<>(permutation));
            return;
        }

        for(int i = index; i < inputArrayList.size(); i++){
            Collections.swap(permutation, index, i);

            generatePermutations(new ArrayList<>(permutation), index + 1);

            Collections.swap(permutation, index, i);
        }
    }

    public static void main(String[] args) {

        generatePermutations(new ArrayList<Integer>(inputArrayList), 0);
        System.out.println("The result => "+ result);
    }
}

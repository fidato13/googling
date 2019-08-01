package com.trn.googling.algorithms.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleRescursionExamples {

    private static Logger LOG = LoggerFactory.getLogger(SimpleRescursionExamples.class);

    private int calculateSum(int n){
        if(n == 1){
            return 1;
        }

        return n + calculateSum(n - 1);
    }

    private int calculateFactorial(int n){
        if(n == 1){
            return 1;
        }

        return n * calculateFactorial(n - 1);
    }

    /**
     * Given an array,arr of integers, write a recursive function that adds sum of all the previous numbers to each index of the array.
     * Input array : {1,2,3,4,5,6}
     * Output array : {1,3,6,10,15,21}
     */
    private void recursiveArraySum(int[] arr, int index) {

        if (index >= arr.length) {
            return;
        }

        recursiveArraySum(arr, index + 1);

        int sum = 0;

        for (int j = 0; j <= index; j++) {
            sum += arr[j];
        }

        arr[index] = sum;


    }


    private void towerOfHanoi(String source, String destination, String extra, Integer totalDiscs){

        /**
         * Three simple steps to solve , recursion
         * 1. Move (totalDiscs - 1) from source to extra using destination peg
         * 2. Move (totalDiscsth) from source to destination peg
         * 3. move (totalDiscs - 1) from extra to destination using source
         */

        if(totalDiscs <= 0){
            return; //end of recursion
        }

        towerOfHanoi(source, extra, destination, totalDiscs - 1);
        LOG.info("Move disc : "+ totalDiscs + " from : "+ source + " to " + destination);
        towerOfHanoi(extra, destination, source, totalDiscs - 1);
    }

    private void tableOfN(int number, int i){
        if(i > 10){
            return;
        }

        LOG.info(number + " * "+ i + " = "+ (number * i));

        tableOfN(number, i + 1);
    }

    public static void main(String[] args) {
        SimpleRescursionExamples simpleRescursionExamples = new SimpleRescursionExamples();

        //[1]
//        int resultSum = simpleRescursionExamples.calculateSum(10);
//
//        //[2]
//        int resultFactorial = simpleRescursionExamples.calculateFactorial(4);
//
//        int[] arr = new int[]{1,2,3,4,5,6};
//
//        //[3]
//        simpleRescursionExamples.recursiveArraySum(arr, 0);
//
//        //[4]
//        simpleRescursionExamples.towerOfHanoi("first peg", "third peg", "second peg", 4);
//
//        simpleRescursionExamples.tableOfN(12, 1);
//
//        LOG.info("result for sum : "+resultSum);
//        LOG.info("result for factorial : "+resultFactorial);
//        LOG.info("result for recursiveArraySum : "+ arr[0]);


    }
}

package com.trn.googling.datastructure.trees.heap;

import java.util.PriorityQueue;

public class PQKthLargest {

    // the idea is to only maintain a min heap queue with size of 2 if k = 3...i.e. of size k - 1
    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    private Integer queueSize;

    public PQKthLargest(int k, int[] nums) {
        this.queueSize = k - 1;

        for(int num: nums){
            priorityQueue.add(num);
        }

        while(priorityQueue.size() > queueSize + 1){
            priorityQueue.poll();
        }
    }

    public int add(int val) {
        priorityQueue.add(val);

        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        PQKthLargest pqKthLargest = new PQKthLargest(3, new int[]{4,5,8,2});

        pqKthLargest.add(3);
        pqKthLargest.add(5);
        pqKthLargest.add(10);
        pqKthLargest.add(9);
        pqKthLargest.add(4);


    }
}

package com.trn.googling.datastructure.trees.heap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    private static Logger LOG = LoggerFactory.getLogger(PriorityQueueExample.class);

    private PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(Collections.reverseOrder());


    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones){
            priorityQueue.add(stone);
        }

        int stone1 = 0;
        int stone2 = 0;

        while(!priorityQueue.isEmpty()){
            if(priorityQueue.size() <= 1){
                break;
            }
            stone1 = priorityQueue.poll();
            stone2 = priorityQueue.poll();

            if(stone1 != stone2){
                priorityQueue.add(Math.abs(stone1 - stone2));
            }

        }

        return (priorityQueue.size() == 1) ? priorityQueue.poll() : 0;
    }

    public static void main(String[] args) {
        PriorityQueueExample priorityQueueExample = new PriorityQueueExample();
        priorityQueueExample.lastStoneWeight(new int[]{7,6,7,6,9});
    }
}

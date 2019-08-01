package com.trn.googling.datastructure.trees.heap;

import java.util.PriorityQueue;

public class PriorityQueueDistanceOriginExample {

    PriorityQueue<DistanceOrigin> priorityQueue;

    int desiredSize = 0;

    public int[][] kClosest(int[][] points, int K) {
        //Euclidean distance. (x,y) & (a,b)
        // sqrt((x - a)^2 + (y - b)^2 )

        int[][] result = new int[K][2];

        initialize(K);

        for(int[] point : points){
            add(new DistanceOrigin(point));
        }

        int count = 0;
        while(!priorityQueue.isEmpty()){
            System.out.println("point is : "+ priorityQueue.peek().point);
            result[count] = priorityQueue.poll().point;
            count++;
        }

        return result;
    }

    private void initialize(int K){
        this.desiredSize = K;

        priorityQueue = new PriorityQueue<>(K);
    }

    private void add(DistanceOrigin distanceOrigin){
        priorityQueue.add(distanceOrigin);

        if(priorityQueue.size() == desiredSize + 1){
            priorityQueue.poll();
        }
    }

    public class DistanceOrigin implements Comparable<DistanceOrigin> {
        int[] point;
        Double distanceFromOrigin;

        public DistanceOrigin(int[] point){
            this.point = point;
            this.distanceFromOrigin = getEuclideanDistanceFromOrigin(point[0], point[1]);
        }

        private Double getEuclideanDistanceFromOrigin(int x, int y){
            return Math.sqrt((x * x) + (y * y));
        }


        @Override
        public int compareTo(DistanceOrigin o) {
            if(this.distanceFromOrigin > o.distanceFromOrigin){
                return 1;
            } else if(this.distanceFromOrigin < o.distanceFromOrigin){
                return -1;
            } else {
                return 0;
            }
        }
    }


    public static void main(String[] args) {
        PriorityQueueDistanceOriginExample priorityQueueDistanceOriginExample = new PriorityQueueDistanceOriginExample();

        int[][] input = new int[2][2];
        input[0] = new int[]{1,3};
        input[1] = new int[]{-2,2};

        priorityQueueDistanceOriginExample.kClosest(input,1);
    }



}

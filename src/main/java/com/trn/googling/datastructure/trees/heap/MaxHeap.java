package com.trn.googling.datastructure.trees.heap;


/**
 * A heap is implemented using arrays
 * and by clever indexing we will know the tree structure:
 *
 * the `zeroth(0)` index is not used at all in order to simplify the below calculation...
 *
 * if `i` is the index of the root node of a tree/subtree
 * then `2*i` would be its left child & `2*i + 1` would be it's right child
 *
 * Also, any node's parent is `i/2` ..and if this value comes out to be 0 then that means that it is a root node as the index would be 1...and 1/2 will be 0.
 *
 */
public class MaxHeap {

    private int getParentIndex(int index){
        return index / 2;
    }

    private int getLeftChildIndex(int index){
        return 2 * index;
    }

    private int getRightChildIndex(int index){
        return (2 * index) + 1;
    }

    private void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }


    /**
     * Heapify is an operation to turn an imbalanced heap or a completely random array/tree into a heap (max or min)
     * since the leaves of the heap would always be in the last indexes of the array , so we would start the heapify from there
     * infact since Heap is a complete binary tree, so the number of leaves is (N / 2) assuming N is the total number of nodes in the Heap
     * N / 4 elements in the level above and so on.
     * and as leaf nodes are 1 element heap already so we can start from the second last level and move upwards
     *
     */
    private void maxHeapify(int[] arr, int index){

        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        int largestIndex = -1;

        // check if it is greater than both of its children , else swap it with larger of the children
        if(leftChildIndex < arr.length && arr[index] < arr[leftChildIndex]){
            largestIndex = leftChildIndex;
        } else {
            largestIndex = index;
        }

        if(rightChildIndex < arr.length && arr[rightChildIndex] > arr[largestIndex]){
            largestIndex = rightChildIndex;
        }

        if(largestIndex != index){
            swap(arr, index, largestIndex);

            maxHeapify(arr, largestIndex);

        }

    }

    private void buildMaxHeap(int[] arr){
        int totalElements = arr.length - 1; // since we don't use zeroth index

        for(int i = totalElements / 2; i >= 1; i--){
            maxHeapify(arr, i);
        }

    }

    public static void main(String[] args) {
        //let's create an input array
        //int[] heapArray = new int[] {-1, 6,4,5,3,2,0,1};

        int[] randomArray1 = new int[] {-1, 3,5,2,4,1,6,0};

        MaxHeap maxHeap = new MaxHeap();
        maxHeap.buildMaxHeap(randomArray1);

    }

    // TODO : Insert an element in heap
    // TODO : Remove the max/min element from the heap
}

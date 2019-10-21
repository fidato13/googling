package com.trn.googling.algorithms.recursion;

import java.util.Arrays;

public class PartitionToKSubsets {

    public boolean search(int[] groups, int row, int[] nums, int target) {
        if(row < 0){
            return true;
        }

        int value = nums[row--];

        for(int i = 0; i < groups.length; i++){
            if(groups[i] + value <= target){
                groups[i] += value;

                if(search(groups, row, nums, target)){
                    return true;
                }

                groups[i] -= value;
            }

            if(groups[i] == 0) {
                break;
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums == null || k == 0){
            return false;
        }

        if(k == 1){
            return true;
        }

        int totalSum = 0;
        for(int num : nums){
            totalSum+= num;
        }

        int subsetSum = totalSum / k;

        //sort the array
        Arrays.sort(nums);
        int row = nums.length - 1;
        if(nums[row] > subsetSum){
            return false;
        }
        while(row >= 0 && nums[row] == subsetSum){
            row--;
            k--;
        }

       return search(new int[k], row, nums, subsetSum); // first param is the smaller array representing subsets(groups) as the other items which were equal to subsetSum were not considered , second argument is row, which is upto the last index on which we will consider the subset


    }



    public static void main(String[] args) {
        PartitionToKSubsets partitionToKSubsets = new PartitionToKSubsets();
        boolean result = partitionToKSubsets.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1, 1, 2, 3, 2, 5}, 3);
        System.out.println("result => "+ result);
    }
}

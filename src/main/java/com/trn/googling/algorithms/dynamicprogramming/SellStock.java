package com.trn.googling.algorithms.dynamicprogramming;

public class SellStock {

    private static int profit = 0;

    public static int maxProfit(int[] prices) {
        for(int i = 0; i < prices.length; i++){
            helper(prices, i, i+1);
        }

        return profit;
    }

    public static void helper(int[] prices, int buy, int sell){
        if(sell == prices.length){
            return;
        }

        if(prices[buy] - prices[sell] > profit){
            profit = prices[buy] - prices[sell];
            System.out.println("buy => "+ buy + " , and sell is => "+ sell + ", and profit is "+ profit);
        }

        helper(prices, buy, sell + 1);
    }

    public static void main(String[] args) {
        maxProfit(new int[]{7,1,5,3,6,4});
    }
}

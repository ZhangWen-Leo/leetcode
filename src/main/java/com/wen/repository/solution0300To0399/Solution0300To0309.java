package com.wen.repository.solution0300To0399;

public class Solution0300To0309 {

    /**
     * 303. Range Sum Query - Immutable
     *
     * 见/design/NumArray
     */

    /**
     * 309. Best Time to Buy and Sell Stock with Cooldown
     */
    private int[] profit;
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }
        profit = new int[length];
        profit[length-1] = 0;
        for(int i = length - 2; i >= 0; i--) {
            profit[i] = profit[i+1];
            for (int j = i+1; j < length; j++) {
                profit[i] = Integer.max(profit[i], prices[j] - prices[i] + getProfit(j+2));
            }
        }

        return profit[0];
    }
    private int getProfit(int x) {
        if (x >= profit.length) {
            return 0;
        }
        return profit[x];
    }
}

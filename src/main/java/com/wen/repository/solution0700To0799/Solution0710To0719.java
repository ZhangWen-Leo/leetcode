package com.wen.repository.solution0700To0799;

public class Solution0710To0719 {

    /**
     * 714. Best Time to Buy and Sell Stock with Transaction Fee
     *
     * 0 < prices.length <= 50000.
     * 0 < prices[i] < 50000.
     * 0 <= fee < 50000.
     */
    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        int[] holding = new int[length], nonHolding = new int[length];

        holding[0] = -prices[0];
        nonHolding[0] = 0;

        for (int i = 1; i < length; i++) {
            holding[i] = Math.max(holding[i-1], nonHolding[i-1] - prices[i]);
            nonHolding[i] = Math.max(nonHolding[i-1], holding[i-1] + prices[i] - fee);
        }

        return Math.max(holding[length-1], nonHolding[length-1]);
    }
}

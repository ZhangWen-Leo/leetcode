package com.wen.repository.solution0800To0899;

import java.util.HashMap;

public class Solution0870To0879 {

    /**
     * 879. Profitable Schemes
     *
     * 1 <= n <= 100
     * 0 <= minProfit <= 100
     * 1 <= group.length <= 100
     * 1 <= group[i] <= 100
     * profit.length == group.length
     * 0 <= profit[i] <= 100
     *
     * TODO
     */
    private int[][][] profitDp;
    private int[] group;
    private int[] profit;
    private int[] sum;
    private int len;
    private static int mod = 1000000007;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        len = group.length;
        profitDp = new int[n + 1][minProfit+1][len];
        this.group = group;
        this.profit = profit;
        sum = new int[len];
        sum[len - 1] = profit[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            sum[i] = profit[i] + sum[i+1];
        }

        int res = getProfit(n, minProfit, 0);
        return res;
    }
    private int getProfit(int n, int target, int start) {
        if (start >= len) {
            return target <= 0 ? 1 : 0;
        }
        if (n == 0) {
            return target <= 0 ? 1 : 0;
        }
        if (target <= 0) {
            target = 0;
        }
        if (target > sum[start]) {
            return 0;
        }
        if (profitDp[n][target][start] > 0) {
            return profitDp[n][target][start];
        }
        else if (group[start] <= n) {
            profitDp[n][target][start] += getProfit(n - 1, target - profit[start], start + 1);
        }
        profitDp[n][target][start] += getProfit(n, target, start + 1);
        profitDp[n][target][start] %= mod;

        return profitDp[n][target][start];
    }
}

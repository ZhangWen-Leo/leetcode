package com.wen.explore.topInterviewQuestionsMedium;

import java.util.*;

public class DynamicPrograming {
    /**
     * 跳跃游戏
     * 见55
     */

    /**
     * 不同路径
     */
    public int uniquePaths(int m, int n) {
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    nums[i][j] = 1;
                }
                else {
                    nums[i][j] = nums[i-1][j] + nums[i][j-1];
                }
            }
        }
        return nums[m-1][n-1];
    }

    /**
     * 零钱兑换
     */
    private Map<Integer, Integer> coinMap = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (coinMap.containsKey(amount)) {
            return coinMap.get(amount);
        }
        List<Integer> list = new ArrayList<>();
        for (int coin :
                coins) {
            list.add(coinChange(coins, amount - coin));
        }

        coinMap.put(amount, getMin(list));
        return coinMap.get(amount);
    }
    private int getMin(List<Integer> list) {
        if (list.size() == 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int num :
                list) {
            min = num < 0 ? min : Integer.min(min, num);
        }
        return min == Integer.MAX_VALUE ? -1 : min+1;
    }

    /**
     * 最长上升子序列
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int j = list.size()-1;
            if (nums[i] > list.get(j)) {
                list.add(nums[i]);
            }
            else {
                while (j >= 0 && nums[i] <= list.get(j)) {
                    j--;
                }
                list.set(j+1, nums[i]);
            }
        }

        return list.size();
    }
}

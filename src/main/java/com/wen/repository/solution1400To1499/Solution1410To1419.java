package com.wen.repository.solution1400To1499;

import java.util.Arrays;

public class Solution1410To1419 {

    /**
     * 1411. Number of Ways to Paint N × 3 Grid
     *
     * n == grid.length
     * grid[i].length == 3
     * 1 <= n <= 5000
     */
    private static int mod = 1000000007;
    public int numOfWays(int n) {
        int[][] waysDp = new int[n][12];
        int[][] indexes = new int[12][];
        Arrays.fill(waysDp[0], 1);
        indexes[0] = new int[]{1, 2, 4, 5, 10};
        indexes[1] = new int[]{0, 3, 6, 8, 11};
        indexes[2] = new int[]{0, 3, 6, 7};
        indexes[3] = new int[]{1, 2, 7, 10};
        indexes[4] = new int[]{0, 6, 8, 9};
        indexes[5] = new int[]{0, 6, 7, 9, 10};
        indexes[6] = new int[]{1, 2, 4, 5, 11};
        indexes[7] = new int[]{2, 3, 5, 11};
        indexes[8] = new int[]{1, 4, 9, 10};
        indexes[9] = new int[]{4, 5, 8, 11};
        indexes[10] = new int[]{0, 3, 5, 8, 11};
        indexes[11] = new int[]{1, 6, 7, 9, 10};

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 12; j++) {
                waysDp[i][j] = getSum(waysDp[i-1], indexes[j]);
            }
        }
        return getSum(waysDp[n-1]);
    }
    private int getSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= mod;
        }
        return sum;
    }
    private int getSum(int[] nums, int[] indexes) {
        int sum = 0;
        for (int i = 0; i < indexes.length; i++) {
            sum += nums[indexes[i]];
            sum %= mod;
        }
        return sum;
    }
}

package com.wen.repository.solution0600To0699;

public class Solution0640To0649 {

    /**
     * 643. Maximum Average Subarray I
     */
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        double sum = 0;
        double maxAverage = Integer.MIN_VALUE;
        int left = 0, right = left;
        while (right < k - 1) {
            sum += nums[right++];
        }
        while (right < len) {
            sum += nums[right];
            maxAverage = Math.max(maxAverage, sum / k);
            sum -= nums[left++];
            right++;
        }

        return maxAverage;
    }
}

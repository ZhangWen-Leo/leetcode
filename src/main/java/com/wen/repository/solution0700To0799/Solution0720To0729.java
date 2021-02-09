package com.wen.repository.solution0700To0799;

public class Solution0720To0729 {

    /**
     * 724. Find Pivot Index
     *
     * The length of nums will be in the range [0, 10000].
     * Each element nums[i] will be an integer in the range [-1000, 1000].
     */
    public int pivotIndex(int[] nums) {
        int len = nums.length;

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }

        int leftSum = 0, rightSum = sum;
        for (int i = 0; i < len; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}

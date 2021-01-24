package com.wen.repository.solution0600To0699;

public class Solution0670To0679 {

    /**
     * 674. Longest Continuous Increasing Subsequence
     *
     * 0 <= nums.length <= 10^4
     * -10^9 <= nums[i] <= 10^9
     */
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int res = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                count++;
                res = Math.max(res, count);
            }
            else {
                count = 1;
            }
        }

        return res;
    }
}

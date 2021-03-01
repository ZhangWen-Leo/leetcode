package com.wen.repository.solution0300To0399.design;

/**
 * 303. Range Sum Query - Immutable
 *
 * 0 <= nums.length <= 10^4
 * -10^5<= nums[i] <=10^5
 * 0 <= i <= j < nums.length
 * At most 10^4 calls will be made to sumRange.
 */
public class NumArray {

    int[] sums;

    public NumArray(int[] nums) {
        int len = nums.length;
        sums = new int[len + 1];
        sums[0] = 0;
        for (int i = 0; i < len; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j+1] - sums[i];
    }
}

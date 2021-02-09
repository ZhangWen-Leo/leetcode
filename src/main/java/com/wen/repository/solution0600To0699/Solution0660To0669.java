package com.wen.repository.solution0600To0699;

public class Solution0660To0669 {

    /**
     * 665. Non-decreasing Array
     */
    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        boolean check = false;
        int last = Integer.MIN_VALUE, preLast = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            if (nums[i] < last) {
                if (check) {
                    return false;
                }
                else {
                    if (nums[i] >= preLast) {
                        last = nums[i];
                    }
                    check = true;
                }
            }
            else {
                preLast = last;
                last = nums[i];
            }
        }
        return true;
    }
}

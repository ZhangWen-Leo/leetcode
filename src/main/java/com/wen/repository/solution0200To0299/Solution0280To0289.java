package com.wen.repository.solution0200To0299;

public class Solution0280To0289 {

    /**
     * 283. Move Zeroes
     */
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i++] = nums[j++];
            }
            else {
                j++;
            }
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }
}

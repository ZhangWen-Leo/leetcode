package com.wen.repository.solution0100To0199;

public class Solution0180To0189 {

    /**
     * 189. Rotate Array
     */
    public void rotate(int[] nums, int k) {
        int start = -1;
        for (int i = 0, j = -1, temp = nums[i]; i < nums.length; i++) {
            if (j == start) {
                j++;
                start++;
                temp = nums[j];
            }
            j = (j+k) % nums.length;
            temp += nums[j];
            nums[j] = temp - nums[j];
            temp -= nums[j];
        }
    }
}

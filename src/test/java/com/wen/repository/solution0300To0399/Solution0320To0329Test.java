package com.wen.repository.solution0300To0399;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Solution0320To0329Test {

    Solution0320To0329 solution = new Solution0320To0329();

    @Test
    public void maxNumber() {
        int[] nums1 = {6, 7};
        int[] nums2 = {6, 0, 4};
        int k = 5;

        System.out.println(Arrays.toString(solution.maxNumber(nums1, nums2, k)));
    }

    @Test
    public void longestIncreasingPath() {
        int[][] matrix = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        System.out.println(solution.longestIncreasingPath(matrix));
    }
}
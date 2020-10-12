package com.wen.repository.solution0001To0099;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution0010To0019Test {

    Solution0010To0019 solution = new Solution0010To0019();

    @Test
    public void intToRoman() {
        System.out.println(solution.intToRoman(3999));
    }

    @Test
    public void threeSum() {
        int[] nums = {
                -1,0,1,2,-1,-4
        };
        System.out.println(solution.threeSum(nums));
    }
}
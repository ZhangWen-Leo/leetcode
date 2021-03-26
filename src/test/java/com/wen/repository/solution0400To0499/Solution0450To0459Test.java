package com.wen.repository.solution0400To0499;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution0450To0459Test {

    private Solution0450To0459 solution = new Solution0450To0459();

    @Test
    public void fourSumCount() {
        int[] A = {-1,1,1,1,-1};
        int[] B = {0,-1,-1,0,1};
        int[] C = {-1,-1,1,-1,-1};
        int[] D = {0,1,0,-1,-1};

        System.out.println(solution.fourSumCount(A, B, C, D));
    }

    @Test
    public void find132pattern() {
        int[] nums = {10,11,15,20,5,6,8,1,3,4,19};
        System.out.println(solution.find132pattern(nums));
    }
}
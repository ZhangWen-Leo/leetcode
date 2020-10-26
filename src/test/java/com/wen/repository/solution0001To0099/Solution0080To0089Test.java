package com.wen.repository.solution0001To0099;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution0080To0089Test {

    Solution0080To0089 solution = new Solution0080To0089();

    @Test
    public void removeDuplicates() {
        int[] nums = {
                1,1,1,2,2,3
        };
        System.out.println(solution.removeDuplicates(nums));
    }

    @Test
    public void search() {
        int[] nums = {
                1,3,1,1
        };
        System.out.println(solution.search(nums, 3));
    }
}
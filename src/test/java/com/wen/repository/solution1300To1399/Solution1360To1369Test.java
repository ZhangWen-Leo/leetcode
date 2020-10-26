package com.wen.repository.solution1300To1399;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Solution1360To1369Test {

    Solution1360To1369 solution = new Solution1360To1369();

    @Test
    public void smallerNumbersThanCurrent() {
        int[] nums = {
                8,1,2,2,3
        };
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(nums)));
    }
}
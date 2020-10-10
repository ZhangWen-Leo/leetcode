package com.wen.repository.solution1500To1599;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution1520To1529Test {

    Solution1520To1529 solution = new Solution1520To1529();

    @Test
    public void minNumberOperations() {
        int[] target = {
                1,2,2,4,3,4,5,3
        };
        System.out.println(solution.minNumberOperations(target));
    }
}
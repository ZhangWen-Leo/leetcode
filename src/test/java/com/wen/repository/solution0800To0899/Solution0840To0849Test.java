package com.wen.repository.solution0800To0899;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution0840To0849Test {

    Solution0840To0849 solution = new Solution0840To0849();

    @Test
    public void longestMountain() {
        int[] A = {
                2,1,4,7,3,2,5
        };
        System.out.println(solution.longestMountain(A));
    }
}
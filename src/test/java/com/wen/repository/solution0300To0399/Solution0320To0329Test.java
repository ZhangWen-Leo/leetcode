package com.wen.repository.solution0300To0399;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution0320To0329Test {

    Solution0320To0329 solution = new Solution0320To0329();

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
package com.wen.repository.solution0500To0599;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution0540To0549Test {

    private Solution0540To0549 solution = new Solution0540To0549();

    @Test
    public void findCircleNum() {
        int[][] isConnected = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };

        System.out.println(solution.findCircleNum(isConnected));
    }
}
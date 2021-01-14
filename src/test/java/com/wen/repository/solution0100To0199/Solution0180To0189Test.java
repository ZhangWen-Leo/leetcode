package com.wen.repository.solution0100To0199;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution0180To0189Test {

    Solution0180To0189 solution = new Solution0180To0189();

    @Test
    public void maxProfit() {
        int k = 5;
        int[] prices = {2,4,1,5,2,3,7,2,4,8,9,3,0,4,2,6,2,1,4,7,4,2,5,1,1,1,1,8,9,3,1,5,7,3,2,1};
        System.out.println(solution.maxProfit(k, prices));
    }
}
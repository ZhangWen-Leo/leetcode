package com.wen.repository.solution0400To0499;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution0400To0410Test {

    Solution0400To0410 solution = new Solution0400To0410();

    @Test
    public void removeKdigits() {
        String num = "1432219";
        int k = 5;

        System.out.println(solution.removeKdigits(num, k));
    }
}
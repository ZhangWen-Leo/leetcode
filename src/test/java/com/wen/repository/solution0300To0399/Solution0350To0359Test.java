package com.wen.repository.solution0300To0399;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution0350To0359Test {

    Solution0350To0359 solution = new Solution0350To0359();

    @Test
    public void maxEnvelopes() {
        int[][] envelopes = {
                {5,4},
                {6,4},
                {6,7},
                {2,3}
        };
        System.out.println(solution.maxEnvelopes(envelopes));
    }

    @Test
    public void rearrangeString() {
        String a = "aaabc";

        System.out.println(solution.rearrangeString(a, 3));
    }
}
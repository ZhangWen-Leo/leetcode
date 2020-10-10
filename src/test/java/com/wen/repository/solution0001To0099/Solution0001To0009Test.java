package com.wen.repository.solution0001To0099;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution0001To0009Test {

    Solution0001To0009 solution = new Solution0001To0009();

    @Test
    public void convert() {
        String s = "PAYPALISHIRING";
        System.out.println(solution.convert(s, 4));
    }
}
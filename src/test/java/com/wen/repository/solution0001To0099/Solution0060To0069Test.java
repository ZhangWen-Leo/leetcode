package com.wen.repository.solution0001To0099;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution0060To0069Test {

    Solution0060To0069 solution = new Solution0060To0069();

    @Test
    public void isNumber() {
        System.out.println(solution.isNumber("0. .e"));
    }

    @Test
    public void fullJustify() {
        String[] words = {
                "This", "is", "an", "example", "of", "text", "justification."
        };
        System.out.println(solution.fullJustify(words, 16));
    }
}
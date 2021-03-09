package com.wen.repository.solution0200To0299;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Solution0210To0219Test {

    Solution0210To0219 solution = new Solution0210To0219();

    @Test
    public void findOrder() {
        int numCourses = 2;
        int[][] prerequisites = {
                {1, 0}
        };
        System.out.println(Arrays.toString(solution.findOrder(numCourses, prerequisites)));
    }

    @Test
    public void shortestPalindrome() {
        int count = 20;
        String s = "a";
        while (count > 0) {
            s += s;
            count--;
        }
        System.out.println(solution.shortestPalindrome(s));
    }
}
package com.wen.repository.solution2500To2599;


import org.junit.Assert;
import org.junit.Test;

public class Solution2500To2509Test {
    Solution2500To2509 solution = new Solution2500To2509();

    @Test
    public void similarPairs() {
        Assert.assertEquals(2, solution.similarPairs(new String[]{
                "aba","aabb","abcd","bac","aabc"
        }));
        Assert.assertEquals(3, solution.similarPairs(new String[]{
                "aabb","ab","ba"
        }));
        Assert.assertEquals(0, solution.similarPairs(new String[]{
                "nba","cba","dba"
        }));
    }
    @Test
    public void similarPairs2() {
        System.out.println(3&6);
    }
}

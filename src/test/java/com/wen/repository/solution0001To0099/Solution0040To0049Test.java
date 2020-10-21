package com.wen.repository.solution0001To0099;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution0040To0049Test {

    Solution0040To0049 solution = new Solution0040To0049();

    @Test
    public void combinationSum2() {
        int[] candidates = {
                2,5,2,1,2
        };
        int target = 5;
        System.out.println(solution.combinationSum2(candidates, target));
    }

    @Test
    public void trap() {
        int [] height = {
                0,1,0,2,1,0,1,3,2,1,2,1
        };
        System.out.println(solution.trap(height));
    }

    @Test
    public void multiply() {
//        System.out.println(solution.multiply("48", 5));
//        System.out.println(solution.add("0", "40", 0));
        System.out.println(solution.multiply("9133", "0"));
    }

    @Test
    public void isMatch() {
        String s = "adceb";
        String p = "*a*b";
        System.out.println(solution.isMatch(s, p));
    }

    @Test
    public void permuteUnique() {
        int[] nums = {
                1,1,2
        };
        System.out.println(solution.permuteUnique(nums));
    }
}
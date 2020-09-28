package com.wen.repository.solution0001To0099;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution0030To0039Test {

    private Solution0030To0039 solution = new Solution0030To0039();

    @Test
    public void combinationSum() {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        int target = 15;
        System.out.println(solution.combinationSum(a, target));
    }
}
package com.wen.repository.solution0100To0199;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution0100To0110Test {

    Solution0100To0110 solution = new Solution0100To0110();

    @Test
    public void testBuildTree() {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        System.out.println(solution.buildTree(pre, in));
    }

    @Test
    public void buildTree() {
        int[] in = {9,3,15,20,7};
        int[] post = {9,15,7,20,3};
        System.out.println(solution.buildTree(in, post));
    }
}
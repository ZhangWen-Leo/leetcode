package com.wen.repository.solution0200To0299;

import com.wen.dataStructure.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Solution0230To0239Test {

    private Solution0230To0239 solution = new Solution0230To0239();

    @Test
    public void lowestCommonAncestor() {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(4, t1, t2);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        TreeNode t7 = new TreeNode(2, t3, t4);
        TreeNode t8 = new TreeNode(8, t5, t6);
        TreeNode t9 = new TreeNode(6, t7, t8);

        System.out.println(solution.lowestCommonAncestor(t9, t7, t8));
    }

    @Test
    public void countDigitOne() {
        System.out.println(solution.countDigitOne(125));
    }

    @Test
    public void maxSlidingWindow() {
        int[] nums = {9,10,9,-7,-4,-8,2,-6};
        int k = 5;
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, k)));
    }
}
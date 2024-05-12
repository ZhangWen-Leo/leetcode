package com.wen.repository.solution0200To0299;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution0220To0229Test {

    Solution0220To0229 solution = new Solution0220To0229();

    @Test
    public void maximalSquare() {
        
    }

    @Test
    public void countNodes() {
        Solution0220To0229.TreeNode root = new Solution0220To0229.TreeNode(1, new Solution0220To0229.TreeNode(2, new Solution0220To0229.TreeNode(4), new Solution0220To0229.TreeNode(5)), new Solution0220To0229.TreeNode(3, new Solution0220To0229.TreeNode(6), null));
        System.out.println(solution.countNodes(root));
    }
}
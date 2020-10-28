package com.wen.repository.solution0100To0199;

import com.wen.dataStructure.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution0120To0129Test {

    Solution0120To0129 solution = new Solution0120To0129();

    @Test
    public void maxPathSum() {
        System.out.println(solution.maxPathSum(TreeNode.buildTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1})));
    }
}
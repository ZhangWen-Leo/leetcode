package com.wen.repository.solution0001To0099;

import com.wen.dataStructure.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution0090To0099Test {

    Solution0090To0099 solution = new Solution0090To0099();

    @Test
    public void subsetsWithDup() {
        int[] nums = {1,2,2};
        System.out.println(solution.subsetsWithDup(nums));
    }

    @Test
    public void numDecodings() {
        String s = "230";
        System.out.println(solution.numDecodings(s));
    }

    @Test
    public void isInterleave() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        System.out.println(solution.isInterleave(s1, s2, s3));
    }

    @Test
    public void recoverTree() {
        TreeNode root = TreeNode.buildTree(new Integer[]{1, 3, null, null, 2});

        solution.recoverTree(root);

        System.out.println(root);
    }
}
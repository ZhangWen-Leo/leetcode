package com.wen.repository.solution0900To0999;

import com.wen.dataStructure.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution0960To0969Test {

    private Solution0960To0969 solution = new Solution0960To0969();

    @Test
    public void minCameraCover() {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(5, null, t1);
        TreeNode t3 = new TreeNode(9);
        TreeNode t4 = new TreeNode(6, t3, null);
        TreeNode t5 = new TreeNode(3, t2, t4);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(4, null, t6);
        TreeNode t8 = new TreeNode(2, t5, t7);
        TreeNode t9 = new TreeNode(1, t8, null);

        System.out.println(solution.minCameraCover(t9));
    }
}
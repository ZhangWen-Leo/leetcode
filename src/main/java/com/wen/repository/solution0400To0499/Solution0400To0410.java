package com.wen.repository.solution0400To0499;

import com.wen.dataStructure.TreeNode;

public class Solution0400To0410 {
    /**
     * 404. 左叶子之和
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return mySumOfLeftLeaves(root, false);
    }
    public int mySumOfLeftLeaves(TreeNode root, boolean isLeft) {
        int sum = 0;
        if (root.left == null && root.right == null) {
            sum += isLeft ? root.val : 0;
        }
        else {
            if (root.left != null) {
                sum += mySumOfLeftLeaves(root.left, true);
            }
            if (root.right != null) {
                sum += mySumOfLeftLeaves(root.right, false);
            }
        }
        return sum;
    }
}
